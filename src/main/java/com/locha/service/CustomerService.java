package com.locha.service;

import com.locha.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    CustomerDTO getCustomerById(String id);

    String getLastCid();

    ArrayList<CustomerDTO> getAllCustomers();
}
