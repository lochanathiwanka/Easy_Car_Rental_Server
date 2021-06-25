package com.locha.service.impl;

import com.locha.dto.DriverScheduleDTO;
import com.locha.entity.Driver;
import com.locha.entity.DriverSchedule;
import com.locha.exception.ValidationException;
import com.locha.repo.DriverScheduleRepo;
import com.locha.service.DriverScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverScheduleServiceImpl implements DriverScheduleService {

    @Autowired
    private DriverScheduleRepo driverScheduleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDriverSchedule(DriverScheduleDTO dto) {
        if (!driverScheduleRepo.existsById(dto.getDriver_sdid())) {
            DriverSchedule driverSchedule = mapper.map(dto, DriverSchedule.class);
            driverScheduleRepo.save(driverSchedule);
        } else {
            throw new ValidationException("Schedule is already in the system!");
        }
    }

    @Override
    public String getLastId() {
        return driverScheduleRepo.getLastId();
    }

    @Override
    public ArrayList<DriverScheduleDTO> getAll() {
        List<DriverSchedule> all = driverScheduleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<DriverScheduleDTO>>() {
        }.getType());
    }

    @Override
    public void updateSchedule(DriverScheduleDTO dto) {
        if (driverScheduleRepo.existsById(dto.getDriver_sdid())) {
            DriverSchedule driverSchedule = mapper.map(dto, DriverSchedule.class);
            driverScheduleRepo.save(driverSchedule);
        } else {
            throw new ValidationException("Cannot find a driver!");
        }
    }

    @Override
    public void deleteSchedule(String id) {
        if (driverScheduleRepo.existsById(id)) {
            driverScheduleRepo.deleteById(id);
        } else {
            throw new ValidationException("Cannot find a driver!");
        }
    }

    @Override
    public ArrayList<DriverScheduleDTO> getScheduleById(String id) {
        Driver driver = new Driver();
        driver.setDid(id);
        ArrayList<DriverSchedule> all = driverScheduleRepo.findAllByDriver(driver);
        return mapper.map(all, new TypeToken<ArrayList<DriverScheduleDTO>>() {
        }.getType());
    }
}
