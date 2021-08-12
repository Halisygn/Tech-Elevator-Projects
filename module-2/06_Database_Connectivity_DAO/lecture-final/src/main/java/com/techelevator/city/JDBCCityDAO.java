package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +   //define our query
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());    // calling a private method to grab next item in the sequence and set on newCity object
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}
	
	@Override
	public City findCityById(long id) {
		City theCity = null;

		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
				"FROM city "+
				"WHERE id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}


		return theCity;
	}


	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();


		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}


		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {

		List<City> myCities = new ArrayList<>();          //create an empty list to hold results

		String sql = "SELECT id, name, countrycode, district, population " +      //write our query
		             "FROM city " +
				     "WHERE district = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, district);    //executing the query and getting back a list of records

		while (results.next()) {     //loop through all records
			City theCity = mapRowToCity(results);    //map each record to a city object
			myCities.add(theCity);    // add the city object to the list
		}

		return myCities;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		String sql = "UPDATE city set name = ?, countrycode = ?, district = ?, population = ? " +
				     "WHERE id = ?";

		jdbcTemplate.update(sql, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId());


	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM city WHERE id = ?";
		jdbcTemplate.update(sql, id);
		
	}




}
