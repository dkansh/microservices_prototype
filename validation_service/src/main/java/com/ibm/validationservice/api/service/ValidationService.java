package com.ibm.validationservice.api.service;

import com.ibm.validationservice.exception.DataMappingException;
import com.ibm.validationservice.exception.InvalidBookingDateException;
import com.ibm.validationservice.vo.BookingRequestVO;
import com.ibm.validationservice.vo.BookingResponseVO;

public interface ValidationService {
    BookingResponseVO validateAndBookTicket(BookingRequestVO bookingRequestVO) throws DataMappingException, InvalidBookingDateException;
}
