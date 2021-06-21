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
public class Schedule {
    @Id
    private String sdid;

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did")
    private Driver driver;

    private String start_date;
    private String end_date;
}
