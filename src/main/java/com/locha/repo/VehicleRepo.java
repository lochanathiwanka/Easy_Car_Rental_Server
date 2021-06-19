package com.locha.repo;

import com.locha.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query(value = "SELECT vid FROM Vehicle ORDER BY vid DESC LIMIT 1", nativeQuery = true)
    String getLastVid();
}
