package com.hottabych04.example.entity.driver;

public abstract class Driver {
    private static Driver instance;
    public static synchronized Driver getInstance(Driver driver) {
        if (instance == null) {
            instance = driver;
        }
        return instance;
    }
}
