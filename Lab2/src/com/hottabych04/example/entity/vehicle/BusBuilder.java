package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;

public class BusBuilder extends VehicleBuilder {
    public BusBuilder() {
        this.vehicle = new Bus();
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
