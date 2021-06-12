package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {
    private String did;
    private UserDTO user;
    private String name;
    private String address;
    private String contact;
    private String nic;
}
