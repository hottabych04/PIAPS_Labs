package com.hottabych04.example;

import com.hottabych04.example.entity.driver.Driver;
import com.hottabych04.example.entity.passenger.Passenger;
import com.hottabych04.example.entity.vehicle.Vehicle;
import com.hottabych04.example.factory.BusFactory;
import com.hottabych04.example.factory.TaxiFactory;
import com.hottabych04.example.factory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory busFactory = new BusFactory();
        Vehicle bus = busFactory.createVehicle();
        Driver busDriver = busFactory.createDriver();

        bus.boardDriver(busDriver);
        for (int i = 0; i < 30; i++) {
            bus.boardPassenger(new Passenger());
        }
        System.out.println("Автобус готов к отправке: " + bus.isReadyToGo());

        VehicleFactory taxiFactory = new TaxiFactory();
        Vehicle taxi = taxiFactory.createVehicle();
        Driver taxiDriver = taxiFactory.createDriver();

        taxi.boardDriver(taxiDriver);
        for (int i = 0; i < 4; i++) {
            taxi.boardPassenger(new Passenger());
        }
        System.out.println("Такси готово к отправке: " + taxi.isReadyToGo());
    }
}