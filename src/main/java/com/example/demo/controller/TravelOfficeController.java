package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.TravelOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TravelOfficeController {

    @Autowired
    TravelOfficeRepository travelOffice;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
         travelOffice.addCustomer(customer);
        return customer;
    }

    @GetMapping("/customers")
    public Map<Long, Customer> getAll()
    {
        return travelOffice.getAll();
    }
}

