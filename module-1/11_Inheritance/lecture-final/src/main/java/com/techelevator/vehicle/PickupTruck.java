package com.techelevator.vehicle;

public class PickupTruck extends Vehicle {
    private int cargoCapacity; // Capacity in pounds

    public PickupTruck() {
        super();
    }

    public PickupTruck(String make, String model, int cargoCapacity) {
        super(make, model);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Cargo Capacity (lbs): " + cargoCapacity;
    }
}
