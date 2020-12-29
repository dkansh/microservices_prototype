package com.ibm.validationservice.vo;

import com.ibm.validationservice.exception.InvalidBookingDateException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequestVO {
    Long bookingId;
    LocalDate startDate;
    LocalDate endDate;
    String personName;

    public boolean validate() throws InvalidBookingDateException {
        if (this.startDate.isAfter(this.endDate)) {
            throw new InvalidBookingDateException(new ErrorVO("ER-101", "Booking start date can't be grater than end date"));
        }
        return true;
    }
}
