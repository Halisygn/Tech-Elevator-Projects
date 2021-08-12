package com.techelevator.homes.controller;

import com.techelevator.homes.dao.HomeDAO;
import com.techelevator.homes.exception.HomeNotFoundException;
import com.techelevator.homes.model.Address;
import com.techelevator.homes.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class HomeController {

    @Autowired
    private HomeDAO dao;

// below is the other way to do dependency injection
//    public HomeController(HomeDAO dao) {
//       this.dao = dao;
//    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/homes", method  = RequestMethod.GET)
    public List<Home> retrieveAllHomes() {
        return dao.retrieveHomesForSale();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/homes/{mlsId}", method = RequestMethod.GET)
    public Home retrieveHomeByMLSID(@PathVariable String mlsId) throws HomeNotFoundException {
        return dao.retrieveHomeByMLSId(mlsId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/homes", method = RequestMethod.POST)
    public Home addHome(@Valid @RequestBody Home home) {
        return dao.addHome(home);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/homes/{mlsId}", method = RequestMethod.DELETE)
    public void deleteHome(@PathVariable String mlsId) throws HomeNotFoundException {
        dao.deleteHome(mlsId);
    }


}
