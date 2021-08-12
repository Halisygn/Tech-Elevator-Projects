package com.techelevator.homes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.homes.domain.Address;
import com.techelevator.homes.domain.Home;

public class HomeSqlDAO implements HomeDAO{
	
	
	private JdbcTemplate jdbcTemplate;
	
	public HomeSqlDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	

	
	// TODO: Build DAO methods here
	
	
	

	@Override
	public List<Home> retrieveHomesForSale() {
		
		List<Home> homesForSale = new ArrayList<Home>();
		
		String sql = "SELECT home.*, address.* " +
		             "FROM home " +
				     "JOIN address ON home.addressid = address.addressid";
		
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		
		while (results.next()) {
			
			Home home = mapRowToHome(results);
			homesForSale.add(home);
			
		}
		
		
		return homesForSale;
	}



	@Override
	public void addHome(Home home) {
		
		int nextAddressId = getNextAddressId();
		
		String addressSQL = "INSERT INTO address(addressId, addressLine, city, state, zip) " +
                "VALUES(?, ?, ?, ?, ?)";
		
		
		jdbcTemplate.update(addressSQL, 
                nextAddressId,
                home.getAddress().getAddressLine(), 
                home.getAddress().getCity(),
                home.getAddress().getState(),
                home.getAddress().getZipCode()
                );	
		
		String homeSQL = "INSERT INTO home (mlsNumber, addressid, numberofbathrooms, numberofBedrooms, price, shortdescription) " +
                "VALUES(?,?,?,?,?,?)";
		
		jdbcTemplate.update(homeSQL, 
                home.getMlsNumber(),
                nextAddressId,
                home.getNumberOfBathrooms(),
                home.getNumberOfBedrooms(),
                home.getPrice(),
                home.getShortDescription()
         );
		
		
	}



	@Override
	public Home retrieveHomeByMLSId(String mlsId) {

		Home home = null;
		
		String sql = "SELECT home.*, address.* " +
	             "FROM home " +
			     "JOIN address ON home.addressid = address.addressid " +
	             "WHERE mlsnumber = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, mlsId);
		
		if (result.next()) {
			home = mapRowToHome(result);
		}
		
		
		return home;
		
	}



	@Override
	public boolean deleteHome(String mlsId) {
		
		String addressIdSql = "SELECT addressid from home WHERE mlsnumber = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(addressIdSql, mlsId);
		
		int addressId;
		
		if (results.next()) {
			addressId = results.getInt("addressId");
		}
		else {
			return false;
		}
		
		//first delete the home.. 
		String sql = "DELETE FROM home WHERE mlsNumber = ?";
		jdbcTemplate.update(sql, mlsId);
		
		//now delete the address
		String addressSQL = "DELETE FROM address where addressId = ?";
		jdbcTemplate.update(addressSQL, addressId);
		
	
		return true;
	}

	

	
	
	private Home mapRowToHome(SqlRowSet results) {
		Home home = new Home();
		
		home.setNumberOfBathrooms(results.getDouble("numberOfBathrooms"));
		home.setMlsNumber(results.getString("mlsNumber"));
		home.setPrice(results.getBigDecimal("price"));
		home.setNumberOfBedrooms(results.getDouble("numberOfBedrooms"));
        home.setShortDescription(results.getString("shortDescription"));
		
        Address address = new Address();
        address.setAddressLine(results.getString("addressLine"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZipCode(results.getInt("zip"));
        
        home.setAddress(address);
        
		return home;
	}	
	
	
	
	private int getNextAddressId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('address_addressid_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new address");
		}
	}







}
