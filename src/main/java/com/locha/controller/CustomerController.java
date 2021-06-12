package com.locha.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getMethod() {
        return "Get method invoked!";
    }

    @GetMapping(params = {"id"})
    public String test() {
        return "Param method invoked!";
    }
}
