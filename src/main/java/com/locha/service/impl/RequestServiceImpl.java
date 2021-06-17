package com.locha.service.impl;

import com.locha.dto.RequestDTO;
import com.locha.entity.Request;
import com.locha.exception.ValidationException;
import com.locha.repo.RequestRepo;
import com.locha.service.RequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRequest(RequestDTO dto) {
        if (requestRepo.existsById(dto.getRid())) {
            throw new ValidationException("Request is already in the system..");
        } else {
            Request request = mapper.map(dto, Request.class);
            requestRepo.save(request);
        }
    }

    @Override
    public void deleteRequest(String id) {
        if (requestRepo.existsById(id)) {
            requestRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no request matches in the system..");
        }
    }

    @Override
    public void updateRequest(RequestDTO dto) {
        if (requestRepo.existsById(dto.getRid())) {
            Request request = mapper.map(dto, Request.class);
            requestRepo.save(request);
        } else {
            throw new ValidationException("There is no request matches in the system..");
        }
    }

    @Override
    public ArrayList<RequestDTO> findAllRequests() {
        List<Request> all = requestRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<Request>>() {
        }.getType());
    }

    @Override
    public RequestDTO findRequestById(String id) {
        Optional<Request> request = requestRepo.findById(id);
        if (request.isPresent()) {
            Request rq = request.get();
            return mapper.map(rq, RequestDTO.class);
        } else {
            throw new ValidationException("There is no any matching Requests in the system!");
        }
    }

    @Override
    public String getLastRid() {
        return requestRepo.geLastRid();
    }
}
