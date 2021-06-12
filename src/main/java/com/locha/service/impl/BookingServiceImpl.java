package com.locha.service.impl;

import com.locha.dto.BookingDTO;
import com.locha.entity.Booking;
import com.locha.exception.ValidationException;
import com.locha.repo.BookingRepo;
import com.locha.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
