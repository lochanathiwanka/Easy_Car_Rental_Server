package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    @Id
    private String aid;

    @OneToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid", insertable = false, updatable = false)
    private User user;

    private String name;
}
