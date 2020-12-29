package com.ibm.bookingservice.entity;

import com.ibm.bookingservice.constant.BookingStatus;
import com.ibm.bookingservice.vo.BookingVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Booking {
    @PrimaryKey
    Long bookingId;
    LocalDate startDate;
    LocalDate endDate;
    String personName;
    BookingStatus bookingStatus;

    public Booking(BookingVO bookingVO) {
        this.bookingId = bookingVO.getBookingId();
        this.startDate = bookingVO.getStartDate();
        this.endDate = bookingVO.getEndDate();
        this.personName = bookingVO.getPersonName();
        this.bookingStatus = bookingVO.getBookingStatus();
    }
}
