package com.ibm.bookingservice.exception;

import com.ibm.bookingservice.vo.ErrorVO;

import java.util.List;

public class DataMappingException extends BookingAppException {

    public DataMappingException() {
        super();
    }

    public DataMappingException(ErrorVO errorVO) {
        super(errorVO);
    }

    public DataMappingException(List<ErrorVO> errors) {
        super(errors);
    }
}