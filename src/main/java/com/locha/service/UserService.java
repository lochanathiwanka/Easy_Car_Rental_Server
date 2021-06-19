package com.locha.service;

import com.locha.dto.AdminDTO;
import com.locha.dto.CustomerDTO;
import com.locha.dto.DriverDTO;
import com.locha.dto.UserDTO;

public interface UserService {

    void addCustomer(CustomerDTO dto);

    void addAdmin(AdminDTO dto);

    void addDriver(DriverDTO dto);

    UserDTO getUser(String email, String password);
}
