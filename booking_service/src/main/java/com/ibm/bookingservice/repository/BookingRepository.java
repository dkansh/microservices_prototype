package com.ibm.bookingservice.repository;

import com.ibm.bookingservice.entity.Booking;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookingRepository extends CassandraRepository<Booking, Long> {
}
