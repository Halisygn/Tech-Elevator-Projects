package com.techelevator.homes;

public class RentalHome extends Home{

    private int rentalTerm;


    /**
     * Homes must be initially created with an Address and mlsNumber
     *
     * @param address
     * @param mlsNumber
     */
    public RentalHome(Address address, String mlsNumber, int rentalTerm) {
        super(address, mlsNumber);
        this.rentalTerm = rentalTerm;
    }
}
