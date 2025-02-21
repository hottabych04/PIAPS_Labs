package com.hottabych04.example.factory;

import com.hottabych04.example.entity.vehicle.Bus;
import com.hottabych04.example.entity.driver.BusDriver;
import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.vehicle.Vehicle;

public class BusFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Bus();
    }

    @Override
    public Driver createDriver() {
        return Driver.getInstance(new BusDriver());
    }

}
