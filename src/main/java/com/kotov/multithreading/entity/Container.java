package com.kotov.multithreading.entity;

import com.kotov.multithreading.util.ContainerIdGeneration;

public class Container {
    private final long containerId;
    private double height;
    private double length;
    private double width;
    private double weight;

    {
        containerId = ContainerIdGeneration.generateId();
    }

    public Container(double height, double length, double width, double weight) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getContainerId() {
        return containerId;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Container other = (Container) otherObject;
        if (containerId != other.containerId) {
            return false;
        } else if (height != other.height) {
            return false;
        } else if (length != other.length) {
            return false;
        } else if (width != other.width) {
            return false;
        }
        return weight == other.weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(containerId);
        result = prime * result + Double.hashCode(height);
        result = prime * result + Double.hashCode(length);
        result = prime * result + Double.hashCode(width);
        result = prime * result + Double.hashCode(weight);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n" + getClass().getSimpleName());
        result.append("[");
        result.append("containerId = ").append(containerId);
        result.append(", height = ").append(height);
        result.append(", length = ").append(length);
        result.append(", width = ").append(width);
        result.append(", weight = ").append(weight);
        result.append("]");
        return result.toString();
    }
}