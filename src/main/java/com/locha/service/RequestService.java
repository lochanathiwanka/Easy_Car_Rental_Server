package com.locha.service;

import com.locha.dto.RequestDTO;

import java.util.ArrayList;

public interface RequestService {
    void addRequest(RequestDTO dto);

    void deleteRequest(String id);

    void updateRequest(RequestDTO dto);

    ArrayList<RequestDTO> findAllRequests();

    RequestDTO findRequestById(String id);

    String getLastRid();
}
