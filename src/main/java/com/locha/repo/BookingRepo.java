package com.locha.repo;

import com.locha.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking, String> {

    @Query(value = "SELECT bid FROM Booking ORDER BY bid DESC LIMIT 1", nativeQuery = true)
    String geLastBookingId();
}
