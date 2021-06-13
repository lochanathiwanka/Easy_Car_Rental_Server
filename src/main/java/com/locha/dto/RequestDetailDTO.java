package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDetailDTO {
    private String rd_id;
    private RequestDTO request;
    private String vid;
    private String driver;
    private String pickup_date;
    private String return_date;
    private double rental_fee;
    private double ldw_fee;
}
