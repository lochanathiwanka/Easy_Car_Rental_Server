package com.locha.service.impl;

import com.locha.repo.VehicleDetailRepo;
import com.locha.service.VehicleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleDetailServiceImpl implements VehicleDetailService {

    @Autowired
    private VehicleDetailRepo vehicleDetailRepo;


    @Override
    public String getLastVDID() {
        return vehicleDetailRepo.getLastVDID();
    }
}
