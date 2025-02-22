package com.hottabych04.example.entity.vehicle;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;

public abstract class VehicleBuilder {

    protected Vehicle vehicle;

    abstract VehicleBuilder setDriver(Driver driver);

    public abstract VehicleBuilder addPassenger(Passenger passenger);

    public abstract Vehicle build();
}
