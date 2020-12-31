package com.ibm.bookingservice.controller;

import com.ibm.bookingservice.api.service.BookingService;
import com.ibm.bookingservice.exception.BookingNotAvailableException;
import com.ibm.bookingservice.vo.BookingVO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("{bookingId}")
    public ResponseEntity<BookingVO> bookTicket(@PathVariable("bookingId") Long bookingId) throws BookingNotAvailableException {
        return ResponseEntity.ok(bookingService.getBookingDetails(bookingId));
    }
}
