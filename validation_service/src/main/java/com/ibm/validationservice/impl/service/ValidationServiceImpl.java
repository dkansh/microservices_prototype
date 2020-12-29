package com.ibm.validationservice.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.validationservice.api.service.ValidationService;
import com.ibm.validationservice.exception.DataMappingException;
import com.ibm.validationservice.exception.InvalidBookingDateException;
import com.ibm.validationservice.vo.BookingRequestVO;
import com.ibm.validationservice.vo.BookingResponseVO;
import com.ibm.validationservice.vo.ErrorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ValidationServiceImpl implements ValidationService {

    @Value("${kafka.validation.topic:Booking}")
    private String kafkaBookingTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BookingResponseVO validateAndBookTicket(BookingRequestVO bookingRequest) throws DataMappingException, InvalidBookingDateException {
        BookingResponseVO bookingResponse = new BookingResponseVO();
        if (bookingRequest.validate()) {
            try {
                Long bookingId = generateBookingId();
                bookingRequest.setBookingId(bookingId);
                bookingResponse.setBookingId(bookingId);
                kafkaTemplate.send(kafkaBookingTopicName, objectMapper.writeValueAsString(bookingRequest));
            } catch (JsonProcessingException e) {
                throw new DataMappingException(new ErrorVO("ER-201", "Error wile mapping data to JSON."));
            }
        }
        return bookingResponse;
    }

    private Long generateBookingId(){
        return ThreadLocalRandom.current().nextLong(100000, 1000000);
    }
}
