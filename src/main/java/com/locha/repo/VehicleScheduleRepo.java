package com.locha.repo;

import com.locha.entity.VehicleSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleScheduleRepo extends JpaRepository<VehicleSchedule, String> {

    @Query(value = "SELECT vehicle_sdid FROM VehicleSchedule ORDER BY vehicle_sdid DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
