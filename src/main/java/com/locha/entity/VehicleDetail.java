package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDetail {
    @Id
    private String vdid;

    @ManyToOne
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    private Vehicle vehicle;

    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String reg_number;
    private String color;
    private String availability;
    private String maintenance;
}
