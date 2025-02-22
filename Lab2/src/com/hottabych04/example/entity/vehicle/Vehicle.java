package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;

public interface Vehicle {
    void boardDriver(Driver driver);
    void boardPassenger(Passenger passenger);
    boolean isReadyToGo();
}