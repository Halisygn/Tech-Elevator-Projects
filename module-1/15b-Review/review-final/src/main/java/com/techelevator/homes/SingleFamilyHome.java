package com.techelevator.homes;

public class SingleFamilyHome extends Home{

    private String neighborhood;

    /**
     * Homes must be initially created with an Address and mlsNumber
     *
     * @param address
     * @param mlsNumber
     */
    public SingleFamilyHome(Address address, String mlsNumber, String neighborhood) {
        super(address, mlsNumber);
        this.neighborhood = neighborhood;

    }
}
