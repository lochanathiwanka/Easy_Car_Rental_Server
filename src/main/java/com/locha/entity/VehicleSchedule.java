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
public class VehicleSchedule {
    @Id
    private String vehicle_sdid;

    @ManyToOne
    @JoinColumn(name = "vdid", referencedColumnName = "vdid")
    private VehicleDetail vehicle;

    private String start_date;
    private String end_date;

}
