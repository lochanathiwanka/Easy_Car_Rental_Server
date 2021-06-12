package com.locha.service.impl;

import com.locha.dto.AdminDTO;
import com.locha.dto.CustomerDTO;
import com.locha.dto.DriverDTO;
import com.locha.entity.Admin;
import com.locha.entity.Customer;
import com.locha.entity.Driver;
import com.locha.entity.User;
import com.locha.exception.ValidationException;
import com.locha.repo.AdminRepo;
import com.locha.repo.CustomerRepo;
import com.locha.repo.DriverRepo;
import com.locha.repo.UserRepo;
import com.locha.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        Optional<Customer> customer = customerRepo.findById(dto.getId());
        Optional<User> user = userRepo.findById(dto.getUser().getUid());

        if (customer.isPresent() || user.isPresent()) {
            throw new ValidationException("Customer is already registered in the db");
        } else {
            Customer cust = mapper.map(dto, Customer.class);
            customerRepo.save(cust);
        }
    }

    @Override
    public void addAdmin(AdminDTO dto) {
        Optional<Admin> admin = adminRepo.findById(dto.getAid());
        Optional<User> user = userRepo.findById(dto.getUser().getUid());

        if (admin.isPresent() || user.isPresent()) {
            throw new ValidationException("Admin is already registered in the db");
        } else {
            Admin a = mapper.map(dto, Admin.class);
            adminRepo.save(a);
        }
    }

    @Override
    public void addDriver(DriverDTO dto) {
        Optional<Driver> driver = driverRepo.findById(dto.getDid());
        Optional<User> user = userRepo.findById(dto.getUser().getUid());

        if (driver.isPresent() || user.isPresent()) {
            throw new ValidationException("Driver is already registered in the db");
        } else {
            Driver d = mapper.map(dto, Driver.class);
            driverRepo.save(d);
        }
    }
}
