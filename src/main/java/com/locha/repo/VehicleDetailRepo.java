package com.locha.repo;

import com.locha.entity.VehicleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleDetailRepo extends JpaRepository<VehicleDetail, String> {

    @Query(value = "SELECT vdid FROM VehicleDetail ORDER BY vdid DESC LIMIT 1", nativeQuery = true)
    String getLastVDID();
}
