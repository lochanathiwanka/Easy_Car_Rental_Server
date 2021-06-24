package com.locha.service.impl;

import com.locha.dto.DriverDTO;
import com.locha.entity.Driver;
import com.locha.entity.User;
import com.locha.exception.ValidationException;
import com.locha.repo.DriverRepo;
import com.locha.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        User user = new User();
        user.setUid("000");
        List<Driver> all = driverRepo.findAllByUserNotLike(user);
        return mapper.map(all, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public String getLastDid() {
        return driverRepo.geLastDid();
    }

    @Override
    public void updateDriverAvailability(String id) {
        Optional<Driver> d = driverRepo.findById(id);
        if (d.isPresent()) {
            Driver driver = d.get();
            driver.setAvailability("Unavailable");
        } else {
            throw new ValidationException("There is no any matching Driver in the system!");
        }
    }
}
