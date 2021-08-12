package com.techelevator.vehicle;

public class Car extends Vehicle {

    private String bodyStyle; // Sedan, hatchback, coupe

    public Car() {
    }

    public Car(String make, String model, String bodyStyle) {
        super(make, model);
        this.bodyStyle = bodyStyle;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public String toString() {
        return super.toString() + " Body Style: " + bodyStyle;
    }
}
