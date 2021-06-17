package com.locha.repo;

import com.locha.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestRepo extends JpaRepository<Request, String> {

    @Query(value = "SELECT rid FROM Request ORDER BY rid DESC LIMIT 1", nativeQuery = true)
    String geLastRid();
}
