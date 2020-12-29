package com.ibm.bookingservice.vo;

import com.ibm.bookingservice.constant.BookingStatus;
import com.ibm.bookingservice.entity.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class BookingVO {
    Long bookingId;
    LocalDate startDate;
    LocalDate endDate;
    String personName;
    BookingStatus bookingStatus;

    public BookingVO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.startDate = booking.getStartDate();
        this.endDate = booking.getEndDate();
        this.personName = booking.getPersonName();
        this.bookingStatus = booking.getBookingStatus();
    }
}
