package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private final String API_BASE_URL;    //localhost:3000 with a slash
    private RestTemplate restTemplate = new RestTemplate();


    //CALLS THE WEB SERVICE WHICH LIVES ON THE SERVER
    //   THIS IS THE CLIENT-SIDE



    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }


    //localhost:3000/hotels
    public Hotel[] listHotels() {
        return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
    }

    // localhost:3000/reviews
    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    //localhost:3000/hotels/2
    public Hotel getHotelById(int id) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
    }


    public Review[] getReviewsByHotelId(int hotelID) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
    }

    //localhost:3000/hotels?stars=3
    public Hotel[] getHotelsByStarRating(int stars) {
        return restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581", City.class);
    }

}
