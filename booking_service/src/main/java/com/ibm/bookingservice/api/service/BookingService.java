package com.ibm.bookingservice.api.service;

import com.ibm.bookingservice.exception.BookingNotAvailableException;
import com.ibm.bookingservice.vo.BookingVO;

public interface BookingService {
    BookingVO getBookingDetails(Long bookingId) throws BookingNotAvailableException;
}
