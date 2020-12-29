package com.ibm.bookingservice.exception;

import com.ibm.bookingservice.vo.ErrorVO;

import java.util.List;

public class BookingNotAvailableException extends BookingAppException {
    public BookingNotAvailableException() {
        super();
    }

    public BookingNotAvailableException(ErrorVO errorVO) {
        super(errorVO);
    }

    public BookingNotAvailableException(List<ErrorVO> errors) {
        super(errors);
    }
}
