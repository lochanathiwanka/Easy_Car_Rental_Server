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
public class Request {
    @Id
    private String rid;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private Customer customer;

    private double total_fee;
    private String bank_slip;
    private String message;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<RequestDetail> request_detail_list = new ArrayList<>();

}
