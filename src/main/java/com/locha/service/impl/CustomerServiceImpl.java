package com.locha.service.impl;

import com.locha.dto.CustomerDTO;
import com.locha.entity.Customer;
import com.locha.entity.User;
import com.locha.exception.ValidationException;
import com.locha.repo.CustomerRepo;
import com.locha.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO getCustomerById(String id) {
        User user = new User();
        user.setUid(id);
        Optional<Customer> c = customerRepo.findByUser(user);
        if (c.isPresent()) {
            Customer customer = c.get();
            return mapper.map(customer, CustomerDTO.class);
        } else {
            throw new ValidationException("There is no any matching Customer in the system!");
        }
    }

    @Override
    public String getLastCid() {
        return customerRepo.geLastCid();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }
}
