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

    private String images;
    private String reg_number;
    private String color;
    private String availability;
    private String maintenance;
}
