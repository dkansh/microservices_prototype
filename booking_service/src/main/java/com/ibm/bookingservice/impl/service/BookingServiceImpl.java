package com.ibm.bookingservice.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.bookingservice.api.service.BookingService;
import com.ibm.bookingservice.entity.Booking;
import com.ibm.bookingservice.entity.Location;
import com.ibm.bookingservice.enums.LocationStatusEnum;
import com.ibm.bookingservice.exception.BookingNotAvailableException;
import com.ibm.bookingservice.repository.BookingRepository;
import com.ibm.bookingservice.repository.LocationRepository;
import com.ibm.bookingservice.vo.BookingVO;
import com.ibm.bookingservice.vo.ErrorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
@Transactional(readOnly = true)
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LocationRepository locationRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BookingVO getBookingDetails(Long bookingId) throws BookingNotAvailableException {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            return new BookingVO(booking.get());
        } else {
            throw new BookingNotAvailableException(new ErrorVO("ER-301", "Booking not available for booking id: " + bookingId));
        }
    }

    @KafkaListener(topics = "Booking", groupId = "bookingSystem")
    @Transactional(readOnly = false)
    public void consumeBooking(String message) {
        try {
            BookingVO bookingVO = objectMapper.readValue(message, BookingVO.class);
            List<Location> locations = locationRepository.findByKeyStatus(LocationStatusEnum.AVAILABLE.getValue());
            if(CollectionUtils.isEmpty(locations)){
                bookingVO.setStatus("Locations not available");
            } else {
                Location location = locations.get(0);
                location.getKey().setStatus(LocationStatusEnum.BOOKED.getValue());
                bookingVO.setStatus("Location assigned: " + location.getLocationName());
                locationRepository.save(location);
            }
            bookingRepository.save(new Booking(bookingVO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
