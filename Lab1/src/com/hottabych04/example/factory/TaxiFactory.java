package com.hottabych04.example.factory;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.driver.TaxiDriver;
import com.hottabych04.example.entity.vehicle.Taxi;
import com.hottabych04.example.entity.vehicle.Vehicle;

public class TaxiFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Taxi();
    }

    @Override
    public Driver createDriver() {
        return Driver.getInstance(new TaxiDriver());
    }

}
