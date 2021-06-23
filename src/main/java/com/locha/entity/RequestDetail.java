package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDetail {
    @EmbeddedId
    private RDCompositeKey pk;

    @ManyToOne
    @JoinColumn(name = "rid", referencedColumnName = "rid", insertable = false, updatable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "vid", referencedColumnName = "vid", insertable = false, updatable = false)
    private Vehicle vehicle;

    private int qty;
    private String driver;
    private String pickup_date;
    private String return_date;
    private double rental_fee;
    private double ldw_fee;
    private String message;
    private String status;
}
