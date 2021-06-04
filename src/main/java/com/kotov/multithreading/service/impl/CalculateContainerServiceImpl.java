package com.kotov.multithreading.service.impl;

import com.kotov.multithreading.entity.Container;
import com.kotov.multithreading.service.CalculateContainerService;

public class CalculateContainerServiceImpl implements CalculateContainerService {
    @Override
    public double calculateVolume(Container container) {
        double volume = container.getHeight() * container.getLength() * container.getWidth();
        return volume;
    }
}
