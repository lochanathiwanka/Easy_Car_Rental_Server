package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompositeKeyDTO implements Serializable {
    private String bid;
    private String vdid;
    private String did;
}
