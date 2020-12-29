package com.ibm.validationservice.exception;

import com.ibm.validationservice.vo.ErrorVO;

import java.util.List;

public class InvalidBookingDateException extends ValidationAppException{

    public InvalidBookingDateException(){
        super();
    }

    public InvalidBookingDateException(ErrorVO errorVO){
        super(errorVO);
    }

    public InvalidBookingDateException(List<ErrorVO> errors){
        super(errors);
    }
}

