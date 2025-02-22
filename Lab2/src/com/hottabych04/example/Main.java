package com.hottabych04.example;

import com.hottabych04.example.entity.driver.BusDriver;
import com.hottabych04.example.entity.driver.TaxiDriver;
import com.hottabych04.example.entity.passenger.*;
import com.hottabych04.example.entity.vehicle.BusBuilder;
import com.hottabych04.example.entity.vehicle.TaxiBuilder;
import com.hottabych04.example.entity.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle bus = new BusBuilder()
                .setDriver(new BusDriver())
                .addPassenger(new AdultPassenger())
                .addPassenger(new BeneficiaryPassenger())
                .addPassenger(new ChildPassenger())
                .build();
        System.out.println("Автобус готов к отправке: " + bus.isReadyToGo());

        Vehicle taxi = new TaxiBuilder()
                .setDriver(new TaxiDriver())
                .addPassenger(new TaxiAdultPassenger())
                .addPassenger(new TaxiChildPassenger())
                .build();
        System.out.println("Такси готово к отправке: " + taxi.isReadyToGo());
    }
}