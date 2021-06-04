package com.kotov.multithreading.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Storehouse {
    private int maxVolume;
    private int maxWeight;
    private final List<Container> containers;

    {
        containers = new ArrayList<>();
    }

    public Storehouse() {
    }

    public Storehouse(int maxVolume, int maxWeight) {
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
    }

    public boolean add(Container container) {
        return containers.add(container);
    }

    public void add(int index, Container container) {
        containers.add(index, container);
    }

    public boolean addAll(Container... containers) {
        return addAll(Arrays.asList(containers));
    }

    public boolean addAll(Collection<Container> containers) {
        return this.containers.addAll(containers);
    }

    public boolean addAll(int index, Collection<Container> containers) {
        return this.containers.addAll(index, containers);
    }

    public boolean remove(Container container) {
        return containers.remove(container);
    }

    public Container remove(int index) {
        return containers.remove(index);
    }

    public boolean removeAll(Collection<Container> containers) {
        return this.containers.removeAll(containers);
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<Container> getContainers() {
        return containers;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Storehouse other = (Storehouse) otherObject;
        if (maxVolume != other.maxVolume) {
            return false;
        }
        if (maxWeight != other.maxWeight) {
            return false;
        }
        if (containers == null) {
            return other.containers == null;
        } else return containers.equals(other.containers);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maxVolume;
        result = prime * result + maxWeight;
        result = prime * result + containers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append("[");
        result.append("maxVolume = ").append(maxVolume);
        result.append(", maxWeight = ").append(maxWeight);
        result.append(", containers = ").append(containers);
        result.append("]");
        return result.toString();
    }
}