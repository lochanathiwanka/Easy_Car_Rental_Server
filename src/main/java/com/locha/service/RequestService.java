package com.locha.service;

import com.locha.dto.CustomeDTO;
import com.locha.dto.RequestDTO;

import java.util.ArrayList;

public interface RequestService {
    void addRequest(RequestDTO dto);

    void deleteRequest(String id);

    void updateRequest(RequestDTO dto);

    ArrayList<RequestDTO> findAllRequests();

    RequestDTO findRequestById(String id);

    ArrayList<RequestDTO> findRequestByCid(String cid);

    String getLastRid();

    ArrayList<RequestDTO> getAllRequests();

    ArrayList<CustomeDTO> test(String id);

    void deleteRequestDetails(String rid);
}
