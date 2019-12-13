package com.example.demo.model;

public class AboardTrip extends Trip {

    private Double insurance;

    public AboardTrip(MyDate start, MyDate end, String destination, Double price) {
        super(start, end, destination,price);
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    @Override
    public Double getPrice() {
        return super.getPrice()+insurance;
    }
}
