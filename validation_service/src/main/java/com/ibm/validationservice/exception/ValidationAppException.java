package com.ibm.validationservice.exception;

import com.ibm.validationservice.vo.ErrorVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidationAppException extends Exception {
    List<ErrorVO> errors;

    ValidationAppException(){
        this.errors = new ArrayList<>();
    }

    ValidationAppException(ErrorVO errorVO){
        this();
        this.errors.add(errorVO);
    }

    ValidationAppException(List<ErrorVO> errors){
        this.errors = errors;
    }
}
