package com.locha.repo;

import com.locha.entity.DriverSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverScheduleRepo extends JpaRepository<DriverSchedule, String> {

    @Query(value = "SELECT driver_sdid FROM DriverSchedule ORDER BY driver_sdid DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
