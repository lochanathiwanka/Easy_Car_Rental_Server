package com.locha.service;

import com.locha.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);

    void deleteVehicle(String id);

    void updateVehicle(VehicleDTO dto);

    ArrayList<VehicleDTO> findAllVehicles();

    VehicleDTO findVehicleById(String id);

    String getLastVid();
}
