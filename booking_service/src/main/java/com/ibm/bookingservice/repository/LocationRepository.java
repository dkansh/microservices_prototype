package com.ibm.bookingservice.repository;

import com.ibm.bookingservice.entity.Location;
import com.ibm.bookingservice.entity.LocationKey;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface LocationRepository extends CassandraRepository<Location, LocationKey> {
    @AllowFiltering
    List<Location> findByKeyStatus(String status);
}
