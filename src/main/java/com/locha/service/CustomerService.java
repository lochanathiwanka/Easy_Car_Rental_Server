package com.locha.service;

import com.locha.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO getCustomerById(String id);

    String getLastCid();
}
