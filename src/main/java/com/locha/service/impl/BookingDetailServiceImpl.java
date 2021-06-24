package com.locha.service.impl;

import com.locha.dto.BookingDetailDTO;
import com.locha.entity.BookingDetail;
import com.locha.repo.BookingDetailRepo;
import com.locha.service.BookingDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingDetailServiceImpl implements BookingDetailService {

    @Autowired
    private BookingDetailRepo bookingDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void updateBookingDetails(BookingDetailDTO dto) {
        BookingDetail bookingDetail = mapper.map(dto, BookingDetail.class);
        bookingDetailRepo.save(bookingDetail);
    }
}
