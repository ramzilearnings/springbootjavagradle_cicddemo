package com.sample.service;

import com.sample.domain.Restaurant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/***
 * @Author Ramzi
 */


public class RestaurantServiceTest {

    static RestaurantService r=null;
    @BeforeAll
    public static void setUp(){
        r=new RestaurantService();
       Restaurant r1=new Restaurant();
                  r1.setId(1l);
                  r1.setName("Kritunga");
                  r1.setLocation("Koramangala");

        r.create(r1);

        Restaurant r2=new Restaurant();
        r2.setId(2l);
        r2.setName("KFC");
        r2.setLocation("Koramangala");
        r.create(r2);

        Restaurant r3=new Restaurant();
        r3.setId(3l);
        r3.setName("A2B");
        r3.setLocation("BTM");
        r.create(r3);

        System.out.println("Inserted list before run:"+r.getAll());
    }
@Test
public void testRun(){
    assertTrue(true);
}
    @Test
    public void findByIdTest(){
        System.out.println("Inserted list before run:"+r.getAll());
        assertEquals(r.findById(1l).getName(),"Kritunga");
        //Assert.assertTrue(true);
    }

    @Test
    public void verifyUpdateLocation(){
        Restaurant updated=new Restaurant();
        updated.setId(3l);
        updated.setName("A2B");
        updated.setLocation("CCochin1");
        r.update(updated);
        assertEquals(r.findById(3l).getLocation(),"CCochin1");
        assertEquals(r.findById(3l).getName(),"A2B");
    }
}
