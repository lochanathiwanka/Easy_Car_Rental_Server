package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private String vid;
    private String brand;
    private String type;
    private int no_of_passenger;
    private String transmission_type;
    private String fuel_type;
    private double daily_rate;
    private double monthly_rate;
    private double ldw_fee;
    private int mileage;
    private String free_mileage;
    private double extra_km_price;
    private List<VehicleDetailDTO> vehicleDetailList = new ArrayList<>();
}
