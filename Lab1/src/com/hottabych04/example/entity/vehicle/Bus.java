package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.BusDriver;
import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;

public class Bus implements Vehicle {

    private BusDriver driver;
    private int passengers = 0;
    private final int maxPassengers = 30;

    @Override
    public void boardDriver(Driver driver) {
        if (driver instanceof BusDriver && this.driver == null) {
            this.driver = (BusDriver) driver;
        }
    }

    @Override
    public void boardPassenger(Passenger passenger) {
        if (passengers < maxPassengers) {
            passengers++;
        }
    }

    @Override
    public boolean isReadyToGo() {
        return driver != null && passengers >= 1;
    }

}

