package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;
import com.hottabych04.example.entity.driver.TaxiDriver;

public class Taxi implements Vehicle {

    private TaxiDriver driver;
    private int passengers = 0;
    private final int maxPassengers = 4;

    @Override
    public void boardDriver(Driver driver) {
        if (driver instanceof TaxiDriver && this.driver == null) {
            this.driver = (TaxiDriver) driver;
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
