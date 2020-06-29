package com.sample.service;

import com.sample.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * @Author Ramzi
 */

@Service
public class RestaurantService {

   Map<Long, Restaurant> dataStore=new HashMap<>();


   public Restaurant findById(Long id){
       return dataStore.get(id);
   }



public List<Restaurant> getAll(){
       return new ArrayList<>(dataStore.values());
}


public void create(Restaurant restaurant){
       dataStore.put(restaurant.getId(),restaurant);
}



public void update(Restaurant updatedRestaurantObject){
       Restaurant restaurantObjectToModify=dataStore.get(updatedRestaurantObject.getId());
    restaurantObjectToModify.setId(updatedRestaurantObject.getId());
    restaurantObjectToModify.setName(updatedRestaurantObject.getName());
    restaurantObjectToModify.setLocation(updatedRestaurantObject.getLocation());
}

public void delete(Long id){
       dataStore.remove(id);
}


}
