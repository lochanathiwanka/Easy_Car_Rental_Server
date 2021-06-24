package com.locha.service.impl;

import com.locha.dto.VehicleScheduleDTO;
import com.locha.entity.VehicleSchedule;
import com.locha.exception.ValidationException;
import com.locha.repo.VehicleScheduleRepo;
import com.locha.service.VehicleScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleScheduleServiceImpl implements VehicleScheduleService {

    @Autowired
    private VehicleScheduleRepo vehicleScheduleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addVehicleSchedule(VehicleScheduleDTO dto) {
        if (!vehicleScheduleRepo.existsById(dto.getVehicle_sdid())) {
            VehicleSchedule vehicleSchedule = mapper.map(dto, VehicleSchedule.class);
            vehicleScheduleRepo.save(vehicleSchedule);
        } else {
            throw new ValidationException("Schedule is already in the system!");
        }
    }

    @Override
    public String getLastId() {
        return vehicleScheduleRepo.getLastId();
    }

    @Override
    public ArrayList<VehicleScheduleDTO> getAll() {
        List<VehicleSchedule> all = vehicleScheduleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleScheduleDTO>>() {
        }.getType());
    }

    @Override
    public void updateSchedule(VehicleScheduleDTO dto) {
        if (vehicleScheduleRepo.existsById(dto.getVehicle_sdid())) {
            VehicleSchedule vehicleSchedule = mapper.map(dto, VehicleSchedule.class);
            vehicleScheduleRepo.save(vehicleSchedule);
        } else {
            throw new ValidationException("Cannot find a vehicle!");
        }
    }

    @Override
    public void deleteSchedule(String id) {
        if (vehicleScheduleRepo.existsById(id)) {
            vehicleScheduleRepo.deleteById(id);
        } else {
            throw new ValidationException("Cannot find a vehicle!");
        }
    }
}
