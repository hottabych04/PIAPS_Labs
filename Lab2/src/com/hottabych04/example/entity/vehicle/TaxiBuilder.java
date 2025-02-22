package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;

public class TaxiBuilder extends VehicleBuilder {
    public TaxiBuilder() {
        this.vehicle = new Taxi();
    }
    @Override
    public VehicleBuilder setDriver(Driver driver) {
        vehicle.boardDriver(driver);
        return this;
    }
    @Override
    public VehicleBuilder addPassenger(Passenger passenger) {
        vehicle.boardPassenger(passenger);
        return this;
    }
    @Override
    public Vehicle build() {
        return vehicle;
    }
}
