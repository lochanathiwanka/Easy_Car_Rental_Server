package com.locha.service;

import com.locha.dto.VehicleScheduleDTO;

import java.util.ArrayList;

public interface VehicleScheduleService {
    void addVehicleSchedule(VehicleScheduleDTO dto);

    String getLastId();

    ArrayList<VehicleScheduleDTO> getAll();

    void updateSchedule(VehicleScheduleDTO dto);

    void deleteSchedule(String id);
}
