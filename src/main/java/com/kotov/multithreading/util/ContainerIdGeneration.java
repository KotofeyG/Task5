package com.kotov.multithreading.util;

public class ContainerIdGeneration {
    private static long idCounter;

    public static long generateId() {
        return ++idCounter;
    }
}