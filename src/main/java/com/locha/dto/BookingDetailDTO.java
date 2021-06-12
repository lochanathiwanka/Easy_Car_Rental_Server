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
    private double rental_fee;
    private double ldw_fee;
}
