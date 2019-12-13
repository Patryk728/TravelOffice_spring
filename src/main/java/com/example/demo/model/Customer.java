package com.example.demo.model;

import lombok.Data;

@Data
public class Customer {


    private Long id;
    private String name;
    private Adress adres;
    private Trip trip;

    public Customer() {

    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adres=" + adres +
                ", trip=" + trip +
                '}';
    }



}
