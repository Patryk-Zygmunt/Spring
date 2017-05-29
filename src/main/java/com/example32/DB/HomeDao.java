package com.example32.DB;

/**
 * Created by Linus on 23.04.2017.
 */
public class HomeDao {




    public long countCars(CarDB cars){
       long amount=cars.count();
        return amount;
    }
}
