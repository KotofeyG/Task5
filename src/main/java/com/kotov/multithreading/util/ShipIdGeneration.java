package com.kotov.multithreading.util;

public class ShipIdGeneration {
    private static long idCounter;

    public static long generateId() {
        return ++idCounter;
    }
}
