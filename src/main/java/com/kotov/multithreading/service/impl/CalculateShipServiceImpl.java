package com.kotov.multithreading.service.impl;

import com.kotov.multithreading.entity.Container;
import com.kotov.multithreading.entity.Ship;
import com.kotov.multithreading.service.CalculateShipService;

public class CalculateShipServiceImpl implements CalculateShipService {
    @Override
    public double calculateContainersWeight(Ship ship) {
        double totalWeight = 0;
        for (Container container : ship.getContainers()) {
            totalWeight += container.getWeight();
        }
        return totalWeight;
    }
}