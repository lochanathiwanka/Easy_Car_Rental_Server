package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDTO {
    private String rid;
    private CustomerDTO customer;
    private double total_fee;
    private String bank_slip;
    private String message;
    private String status;
    private List<RequestDetailDTO> request_detail_list = new ArrayList<>();
}
