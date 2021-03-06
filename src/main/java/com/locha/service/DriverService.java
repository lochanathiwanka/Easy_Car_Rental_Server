package com.locha.service;

import com.locha.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    ArrayList<DriverDTO> getAllDrivers();

    String getLastDid();

    void updateDriverAvailability(String id);

    DriverDTO getDriverById(String id);
}
