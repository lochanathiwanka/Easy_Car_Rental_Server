package com.locha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDetailDTO {
    private CompositeKeyDTO pk;
    private BookingDTO booking;
    private VehicleDTO vehicle;
    private String did;
    private String pickup_date;
    private String return_date;
    private String return_time;
    private double rental_fee;
    private double ldw_fee;
}
