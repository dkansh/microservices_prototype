package com.ibm.bookingservice.controller;

import com.ibm.bookingservice.exception.BookingAppException;
import com.ibm.bookingservice.vo.ErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(BookingAppException.class)
    public ResponseEntity<List<ErrorVO>> appExceptionHandler(BookingAppException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getErrors());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorVO> commonExceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorVO("ER-500", "Server internal error"));
    }
}
