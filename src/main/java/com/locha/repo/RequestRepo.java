package com.locha.repo;

import com.locha.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface RequestRepo extends JpaRepository<Request, String> {

    @Query(value = "SELECT rid FROM Request ORDER BY rid DESC LIMIT 1", nativeQuery = true)
    String geLastRid();

    @Query(value = "SELECT * FROM Request WHERE cid=:cid AND status='show'", nativeQuery = true)
    ArrayList<Request> findRequestByCId(@Param("cid") String cid);
}
