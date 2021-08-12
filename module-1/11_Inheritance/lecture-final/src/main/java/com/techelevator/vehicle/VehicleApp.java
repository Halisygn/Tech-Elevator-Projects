package com.techelevator.vehicle;

public class VehicleApp {

    public static void main(String[] args) {
        VehicleApp vehicleApp = new VehicleApp();
        vehicleApp.run();
    }

    private void run() {
//        Car car = new Car();
//
//        car.setMake("Ford");
//        car.setModel("Bronco");
//        car.setBodyStyle("SUV");
//
//        Car tesla = new Car("Tesla", "Model 3", "4 Door");
//
//        System.out.println(car.getMake() + " " + car.getModel());
//
//        PickupTruck silverado = new PickupTruck();
//        silverado.setMake("Chevrolet");
//        silverado.setModel("Silverado");
//        silverado.setCargoCapacity(1500);
//
//        System.out.println("Tesla : " + tesla.toString());
//        System.out.println(silverado);

        Car bmw = new Car("BMW", "Z4", "2 door");
        Vehicle bmwV = bmw;
        System.out.println(bmwV);


    }
}
