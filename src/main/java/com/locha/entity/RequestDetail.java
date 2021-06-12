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
public class RequestDetail {
    @Id
    private String rd_id;

    @ManyToOne
    @JoinColumn(name = "rid", referencedColumnName = "rid", insertable = false, updatable = false)
    private Request request;

    private String vid;
    private String did;
    private String pickup_date;
    private String return_date;
    private double rental_fee;
    private double ldw_fee;
}
