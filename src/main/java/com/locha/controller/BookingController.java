package com.locha.controller;

import com.locha.dto.BookingDTO;
import com.locha.service.BookingService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooking(@RequestBody BookingDTO dto) {
        bookingService.addBooking(dto);
        return new ResponseEntity(new StandardResponse("200", "Booking was successfull!", dto), HttpStatus.CREATED);
    }
}
