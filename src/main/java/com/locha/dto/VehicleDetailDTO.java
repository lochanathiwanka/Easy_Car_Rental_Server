package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDetailDTO {
    private String vdid;
    private VehicleDTO vehicle;
    private String images;
    private String reg_number;
    private String color;
    private String availability;
    private String maintenance;
}
