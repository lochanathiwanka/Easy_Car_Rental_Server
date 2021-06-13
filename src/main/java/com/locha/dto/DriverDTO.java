package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<ScheduleDTO> scheduleList = new ArrayList<>();
}
