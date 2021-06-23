package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleScheduleDTO {
    private String vehicle_sdid;
    private VehicleDetailDTO vehicle;
    private String start_date;
    private String end_date;
}
