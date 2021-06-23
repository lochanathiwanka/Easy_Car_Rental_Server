package com.locha.service;

import com.locha.dto.RequestDetailDTO;

public interface RequestDetailService {

    void updateRequestMessage(RequestDetailDTO dto);

    void deleteRequestDetails(String rid, String vid);
}
