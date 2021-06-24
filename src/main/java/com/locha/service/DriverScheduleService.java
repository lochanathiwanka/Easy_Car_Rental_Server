package com.locha.service;

import com.locha.dto.DriverScheduleDTO;

import java.util.ArrayList;

public interface DriverScheduleService {
    void addDriverSchedule(DriverScheduleDTO dto);

    String getLastId();

    ArrayList<DriverScheduleDTO> getAll();

    void updateSchedule(DriverScheduleDTO dto);

    void deleteSchedule(String id);
}
