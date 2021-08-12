package com.techelevator.homes.model;

import java.util.List;

import com.techelevator.homes.domain.Home;

public interface HomeDAO {
	
    List<Home> retrieveHomesForSale();
    void addHome(Home home);
    Home retrieveHomeByMLSId(String mlsId);
    boolean deleteHome(String mlsId);
	
}
