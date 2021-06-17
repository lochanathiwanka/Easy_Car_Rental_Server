package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    private String vid;
    private String brand;
    private String type;
    private int no_of_passenger;
    private String transmission_type;
    private String fuel_type;
    private double daily_rate;
    private double monthly_rate;
    private int mileage;
    private double free_mileage_price;
    private double extra_km_price;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleDetail> vehicleDetailList = new ArrayList<>();
}
