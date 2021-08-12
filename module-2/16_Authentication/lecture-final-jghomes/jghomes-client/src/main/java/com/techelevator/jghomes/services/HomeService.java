package com.techelevator.jghomes.services;
import com.techelevator.jghomes.exceptions.HomeServiceException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


import com.techelevator.jghomes.models.Home;

public class HomeService {

    private final String BASE_SERVICE_URL;
    public String AUTH_TOKEN = "";
    private RestTemplate restTemplate = new RestTemplate();

    public HomeService(String baseUrl) {
        this.BASE_SERVICE_URL = baseUrl;
    }

    public Home[] retrieveListOfHomes() throws HomeServiceException {

        Home[] homes = null;


        try {

            // Below is how we did it before. BUT getForObject does not allow for an Entity object so we are forced to use
            // the exchange method below IF we want authentication turned on. If we don't need authentication, we can use
            // getForObject() method.

            //homes = restTemplate.getForObject(BASE_URL + "homes", Home[].class);

            homes = restTemplate.exchange(BASE_SERVICE_URL + "homes", HttpMethod.GET, makeAuthEntity(), Home[].class).getBody();

        }
        catch (RestClientResponseException ex) {
            throw new HomeServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
        }
        return homes;

    }

    public Home retrieveHomesByMLSID(String mlsId) throws HomeServiceException {
        Home home = null;
        // create HTTP header so we can set application/json AND AUTH_TOKEN
        // build and entity object so the header gets added
        // call the web service using the exchange method

        try {
            // Below is how we did it before. BUT getForObject does not allow for an Entity object so we are forced to use
            // the exchange method below IF we want authentication turned on. If we don't need authentication, we can use
            // getForObject() method.
            //home = restTemplate.getForObject(BASE_URL + "homes", Home.class);

            home = restTemplate.exchange(BASE_SERVICE_URL + "homes/" + mlsId, HttpMethod.GET, makeAuthEntity(), Home.class).getBody();
        } catch (RestClientResponseException ex) {
            if(ex.getRawStatusCode() == 404) {
                return null;
            }
            throw new HomeServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
        }

        return home;

    }


    public void addHome(Home home) throws HomeServiceException {

        if(home == null) {
            throw new HomeServiceException("Invalid Home.");
        }

        try {
            restTemplate.exchange(BASE_SERVICE_URL + "homes", HttpMethod.POST, makeHomeEntity(home), String.class);
        }
        catch (RestClientResponseException ex) {
            throw new HomeServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
        }
    }

    public void deleteHome(String mlsId) throws HomeServiceException {

        try {
            restTemplate.exchange(BASE_SERVICE_URL + "homes/" + mlsId, HttpMethod.DELETE, makeAuthEntity(), String.class);
        } catch (RestClientResponseException ex) {
            if(ex.getRawStatusCode() == 404) {
                System.out.println("Not a valid ID. Please try again.");
            }
            throw new HomeServiceException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
        }

    }

    /**
     * IMPORTANT!!!  This gets set by the client once authentication occurs
     *
     * @param aUTH_TOKEN
     */
    public void setAUTH_TOKEN(String aUTH_TOKEN) {
        AUTH_TOKEN = aUTH_TOKEN;
    }


    // MAKE A HOME ENTITY TO USE IN THE BODY
    private HttpEntity<Home> makeHomeEntity(Home home) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity<Home> entity = new HttpEntity<>(home, headers);
        return entity;
    }

    // MAKE AN AUTH ENTITY ONLY
    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

}
