package com.locha.controller;

import com.locha.dto.AdminDTO;
import com.locha.dto.CustomerDTO;
import com.locha.dto.DriverDTO;
import com.locha.service.UserService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/customer")
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {
        userService.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Customer Saved!", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/admin")
    public ResponseEntity addAdmin(@RequestBody AdminDTO dto) {
        userService.addAdmin(dto);
        return new ResponseEntity(new StandardResponse("200", "Admin saved!", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/driver")
    public ResponseEntity addDriver(@RequestBody DriverDTO dto) {
        userService.addDriver(dto);
        return new ResponseEntity(new StandardResponse("200", "Driver saved!", dto), HttpStatus.CREATED);
    }

}
