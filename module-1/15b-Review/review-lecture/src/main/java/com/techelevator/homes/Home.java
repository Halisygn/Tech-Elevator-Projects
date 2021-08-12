package com.techelevator.homes;

public class Home {

	/**
	 * These are member variables. Each home instance in memory will have it's own
	 * copy of this data. All instance variable should be private
	 */

	private String mlsNumber;
	private Address address;
	private double numberOfBedrooms;
	private double numberOfBathrooms;
	private double price;
	private String shortDescription;
	
	
	/**
	 * Homes must be initially created with an Address and mlsNumber 
	 * @param address
	 * @param mlsNumber
	 */
	
	public Home (Address address, String mlsNumber) {
		
		this.address = address;
		this.mlsNumber = mlsNumber;
		
	}

	
	
	
	
	/*
	 * The following are getters/setters. I removed the setter for mlsNUmber and Address as they are fixed values only created
	 * at time of listing.
	 */
	
	public String getMlsNumber() {
		return mlsNumber;
	}

	public Address getAddress() {
		return address;
	}
	
	public double getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	
	public void setNumberOfBedrooms(double numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}
	
	public double getNumberOfBathrooms() {
		return numberOfBathrooms;
	}
	
	public void setNumberOfBathrooms(double numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	

}
