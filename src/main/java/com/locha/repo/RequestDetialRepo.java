package com.locha.repo;

import com.locha.entity.Request;
import com.locha.entity.RequestDetail;
import com.locha.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetialRepo extends JpaRepository<RequestDetail, String> {

    boolean existsByRequest(Request request);

    void deleteByRequestAndVehicle(Request request, Vehicle vehicle);
}
