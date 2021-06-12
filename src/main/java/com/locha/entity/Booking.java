package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    @Id
    private String bid;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingDetail> booking_detail_list = new ArrayList<>();

    private String date;
    private double total_fee;
    private String bank_slip;
}
