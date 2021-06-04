package com.kotov.multithreading.entity;

import com.kotov.multithreading.util.ShipIdGeneration;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ship extends Thread {
    private final long shipId;
    private int maxVolume;
    private int maxWeight;
    private final Deque<Container> containers;

    {
        shipId = ShipIdGeneration.generateId();
        containers = new ArrayDeque<>();
    }

    public Ship(String name) {
        super(name);
    }

    public Ship(String name, int maxVolume, int maxWeight) {
        super(name);
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
    }

    public boolean offerLast(Container container) {
        return containers.offerLast(container);
    }

    public Container pollLast() {
        return containers.pollLast();
    }

    public boolean isEmpty() {
        return containers.isEmpty();
    }

    public boolean isLoaded() {
        return containers.size() != 0;
    }

    public long getShipId() {
        return shipId;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Deque<Container> getContainers() {
        return containers;
    }

    @Override
    public void run() {
        Port port = Port.getInstance();
        while (isLoaded()) {
            for (Pier pier : port.getPiers()) {
                if (isLoaded()) {
                    pier.takeShip(this);
                }
            }
        }
    }
}