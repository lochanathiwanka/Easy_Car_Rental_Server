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
public class BookingDetail {
    @EmbeddedId
    private CompositeKey pk;

    @ManyToOne
    @JoinColumn(name = "bid", referencedColumnName = "bid", insertable = false, updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "vid", referencedColumnName = "vid", insertable = false, updatable = false)
    private Vehicle vehicle;

    private String did;
    private String pickup_date;
    private String return_date;
    private String return_time;
    private double rental_fee;
    private double ldw_fee;
}
