package com.locha.repo;

import com.locha.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailRepo extends JpaRepository<BookingDetail, String> {
}
