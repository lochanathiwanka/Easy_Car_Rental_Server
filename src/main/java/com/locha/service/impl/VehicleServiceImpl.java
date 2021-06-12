package com.locha.service.impl;

import com.locha.dto.VehicleDTO;
import com.locha.entity.Vehicle;
import com.locha.exception.ValidationException;
import com.locha.repo.VehicleRepo;
import com.locha.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsById(dto.getVid())) {
            throw new ValidationException("Vehicle is already in the system!");
        } else {
            Vehicle vehicle = mapper.map(dto, Vehicle.class);
            vehicleRepo.save(vehicle);
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsById(dto.getVid())) {
            Vehicle vehicle = mapper.map(dto, Vehicle.class);
            vehicleRepo.save(vehicle);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public ArrayList<VehicleDTO> findAllVehicles() {
        List<Vehicle> all = vehicleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public VehicleDTO findVehicleById(String id) {
        Optional<Vehicle> v = vehicleRepo.findById(id);
        if (v.isPresent()) {
            Vehicle vehicle = v.get();
            return mapper.map(vehicle, VehicleDTO.class);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }
}
