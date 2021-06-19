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
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String reg_number;
    private String color;
    private String availability;
    private String maintenance;
}
