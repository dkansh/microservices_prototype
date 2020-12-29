package com.ibm.validationservice.controller;

import com.ibm.validationservice.api.service.ValidationService;
import com.ibm.validationservice.exception.DataMappingException;
import com.ibm.validationservice.exception.InvalidBookingDateException;
import com.ibm.validationservice.vo.BookingRequestVO;
import com.ibm.validationservice.vo.BookingResponseVO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("validate")
public class ValidationController {

    @Autowired
    ValidationService validationService;

    @PostMapping
    public ResponseEntity<BookingResponseVO> bookTicket(BookingRequestVO bookingRequest) throws DataMappingException, InvalidBookingDateException {
        return ResponseEntity.ok(validationService.validateAndBookTicket(bookingRequest));
    }
}
