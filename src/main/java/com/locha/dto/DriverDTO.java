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
    private String nic;
    private String nic_image;
    private String dr_license;
    private String dr_license_image;
    private String contact;
    private String availability;
}
