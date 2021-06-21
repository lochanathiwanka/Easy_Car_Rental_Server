package com.locha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "hibernateLazyInitializer"})
public class Vehicle {
    @Id
    private String vid;
    @JsonIgnore
    private String brand;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private int no_of_passenger;
    @JsonIgnore
    private String transmission_type;
    @JsonIgnore
    private String fuel_type;
    @JsonIgnore
    private double daily_rate;
    @JsonIgnore
    private double monthly_rate;
    @JsonIgnore
    private double ldw_fee;
    @JsonIgnore
    private int mileage;
    @JsonIgnore
    private String free_mileage;
    @JsonIgnore
    private double extra_km_price;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleDetail> vehicleDetailList = new ArrayList<>();
}
