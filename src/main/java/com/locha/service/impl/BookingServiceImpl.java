package com.locha.service.impl;

import com.locha.dto.BookingDTO;
import com.locha.entity.Booking;
import com.locha.exception.ValidationException;
import com.locha.repo.BookingRepo;
import com.locha.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addBooking(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getBid())) {
            throw new ValidationException("Booking Id is already in the system..Create a new booking..");
        } else {
            Booking booking = mapper.map(dto, Booking.class);
            bookingRepo.save(booking);
        }
    }

    @Override
    public String getLastBookingId() {
        return bookingRepo.geLastBookingId();
    }

    @Override
    public ArrayList<BookingDTO> getAll() {
        List<Booking> all = bookingRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void updateBooking(String id, double fee) {
        if (bookingRepo.existsById(id)) {
            Booking booking = bookingRepo.getById(id);
            double old_total_fee = booking.getTotal_fee();
            booking.setTotal_fee(old_total_fee + fee);
        } else {
            throw new ValidationException("There is no any matching booking");
        }
    }
}
