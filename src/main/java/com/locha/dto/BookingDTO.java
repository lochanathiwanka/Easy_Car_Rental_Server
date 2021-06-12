package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {
    private String bid;
    private CustomerDTO customer;
    private List<BookingDetailDTO> booking_detail_list = new ArrayList<>();
    private String date;
    private double total_fee;
    private String bank_slip;
}
