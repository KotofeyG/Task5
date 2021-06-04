package com.kotov.multithreading.service;

import com.kotov.multithreading.entity.Ship;

public interface CalculateShipService {
    double calculateContainersWeight(Ship ship);
}
