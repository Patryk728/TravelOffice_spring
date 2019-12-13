package com.example.demo.model;

import lombok.Data;

@Data
public class Trip {
    private MyDate start;
    private MyDate end;
    private String destination;
    private Double price;

    public Trip() {

    }

    public Trip(MyDate start, MyDate end, String destination, Double price) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }


}
