package com.ibm.bookingservice.exception;

import com.ibm.bookingservice.vo.ErrorVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingAppException extends Exception {
    List<ErrorVO> errors;

    BookingAppException() {
        this.errors = new ArrayList<>();
    }

    BookingAppException(ErrorVO errorVO) {
        this();
        this.errors.add(errorVO);
    }

    BookingAppException(List<ErrorVO> errors) {
        this.errors = errors;
    }
}
