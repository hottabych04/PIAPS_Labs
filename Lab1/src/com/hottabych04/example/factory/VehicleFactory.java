package com.hottabych04.example.factory;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.vehicle.Vehicle;

public interface VehicleFactory {

    Vehicle createVehicle();

    Driver createDriver();

}
