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
public class Driver {
    @Id
    private String did;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;

    private String name;
    private String address;
    private String contact;
    private String nic;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

}
