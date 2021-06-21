package com.locha.repo;

import com.locha.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver, String> {

    @Query(value = "SELECT did FROM Driver ORDER BY did DESC LIMIT 1", nativeQuery = true)
    String geLastDid();
}
