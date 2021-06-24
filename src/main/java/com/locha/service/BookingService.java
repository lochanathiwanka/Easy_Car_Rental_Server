package com.locha.service;

import com.locha.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {
    void addBooking(BookingDTO dto);

    String getLastBookingId();

    ArrayList<BookingDTO> getAll();

}
