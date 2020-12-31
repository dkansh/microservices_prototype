package com.ibm.validationservice.controller;

import com.ibm.validationservice.exception.ValidationAppException;
import com.ibm.validationservice.vo.ErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ValidationAppException.class)
    public ResponseEntity<List<ErrorVO>> appExceptionHandler(ValidationAppException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getErrors());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorVO> commonExceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorVO("ER-500", "Server internal error"));
    }
}
