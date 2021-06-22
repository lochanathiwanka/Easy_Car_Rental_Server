package com.locha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompositeKey implements Serializable {
    private String bid;
    private String vdid;
    private String did;
}
