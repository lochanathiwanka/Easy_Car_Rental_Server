package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    private String vid;
    private String brand;
    private String type;
    private String images;
    private int no_of_passenger;
    private String transmission_type;
    private String fuel_type;
    private double daily_rate;
    private double monthly_rate;
    private double free_mileage_price;
    private double extra_km_price;
    private String reg_number;
    private String color;
    private String availability;
}
