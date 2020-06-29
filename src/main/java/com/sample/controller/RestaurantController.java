package com.sample.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sample.BaseResponse;
import com.sample.domain.Restaurant;
import com.sample.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @Author Ramzi
 */

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {

        return new ResponseEntity<Restaurant>(restaurantService.findById(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/restaurants/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return new ResponseEntity<List<Restaurant>>(restaurantService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/restaurants/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.create(restaurant);
        return new ResponseEntity<BaseResponse>(new BaseResponse("success", 1), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantService.findById(restaurant.getId())==null){
            return new ResponseEntity<BaseResponse>(new BaseResponse("id notfound", 9), HttpStatus.NOT_FOUND);
        }

        restaurantService.update(restaurant);
        return new ResponseEntity<BaseResponse>(new BaseResponse("update success", 1), HttpStatus.OK);
    }


    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteAccount(@PathVariable Long id) {
         restaurantService.delete(id);
        return new ResponseEntity<BaseResponse>(new BaseResponse("delete success", 1), HttpStatus.OK);
    }
}