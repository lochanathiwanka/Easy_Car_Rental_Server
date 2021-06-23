package com.locha.service.impl;

import com.locha.dto.RequestDetailDTO;
import com.locha.entity.Request;
import com.locha.entity.RequestDetail;
import com.locha.entity.Vehicle;
import com.locha.exception.NotFoundException;
import com.locha.repo.RequestDetialRepo;
import com.locha.service.RequestDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RequestDetailServiceImpl implements RequestDetailService {

    @Autowired
    private RequestDetialRepo requestDetialRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void updateRequestMessage(RequestDetailDTO dto) {
        RequestDetail requestDetail = mapper.map(dto, RequestDetail.class);
        requestDetialRepo.save(requestDetail);
    }

    @Override
    public void deleteRequestDetails(String rid, String vid) {
        Request request = new Request();
        Vehicle vehicle = new Vehicle();
        request.setRid(rid);
        vehicle.setVid(vid);
        if (requestDetialRepo.existsByRequest(request)) {
            requestDetialRepo.deleteByRequestAndVehicle(request, vehicle);
        } else {
            throw new NotFoundException("Request Details not found!");
        }
    }
}
