package com.locha.service;

import com.locha.dto.VehicleDetailDTO;

public interface VehicleDetailService {

    String getLastVDID();

    void deleteVehicle(String id);

    void updateVehicle(VehicleDetailDTO dto);

    void updateVehicleAvailability(String id, String status);
}
