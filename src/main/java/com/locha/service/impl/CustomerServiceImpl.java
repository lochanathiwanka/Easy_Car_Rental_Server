package com.locha.service.impl;

import com.locha.dto.CustomerDTO;
import com.locha.entity.Customer;
import com.locha.repo.CustomerRepo;
import com.locha.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        Customer customer = mapper.map(dto, Customer.class);
        customerRepo.save(customer);
    }
}
