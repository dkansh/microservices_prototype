package com.ibm.validationservice.exception;

import com.ibm.validationservice.vo.ErrorVO;

import java.util.List;

public class DataMappingException extends ValidationAppException {

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