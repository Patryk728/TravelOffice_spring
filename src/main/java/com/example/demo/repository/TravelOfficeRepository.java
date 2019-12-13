package com.example.demo.repository;

import com.example.demo.exception.MyException;
import com.example.demo.exception.MyException1;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TravelOfficeRepository {



    private Customer customer = new Customer((long) 1,"Adam");
    private Customer customer1 = new Customer((long) 5,"Piotr");

    Map<Long,Customer> customerMap = new HashMap<>();

    {
        customerMap.put(customer.getId(),customer);
        customerMap.put(customer1.getId(),customer1);
    }

    public void addCustomer(Customer customer) {
       // customerMap.put(customer.getId(),customer);
        throw new MyException();

    }

    @Override
    public String toString() {
        return "TravelOffice{" +
                "customerMap=" + customerMap +
                '}';
    }

    public Map<Long, Customer> getAll()
    {
        throw new MyException1();
        //return  customerMap;
    }




}
