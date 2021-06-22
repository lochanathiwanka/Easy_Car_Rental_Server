package com.locha.service.impl;

import com.locha.dto.VehicleDetailDTO;
import com.locha.entity.VehicleDetail;
import com.locha.exception.ValidationException;
import com.locha.repo.VehicleDetailRepo;
import com.locha.service.VehicleDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleDetailServiceImpl implements VehicleDetailService {

    @Autowired
    private VehicleDetailRepo vehicleDetailRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public String getLastVDID() {
        return vehicleDetailRepo.getLastVDID();
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleDetailRepo.existsById(id)) {
            vehicleDetailRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public void updateVehicle(VehicleDetailDTO dto) {
        if (vehicleDetailRepo.existsById(dto.getVdid())) {
            VehicleDetail vehicleDetail = mapper.map(dto, VehicleDetail.class);
            vehicleDetailRepo.save(vehicleDetail);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

}
