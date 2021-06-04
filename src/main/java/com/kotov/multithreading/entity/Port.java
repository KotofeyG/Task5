package com.kotov.multithreading.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Port {
    private Storehouse storehouse;
    private List<Pier> piers;

    private Port() {
        storehouse = new Storehouse();
        piers = new ArrayList<>();
    }

    private static class SingletonHolder {
        private static final Port INSTANCE = new Port();
    }

    public static Port getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public void setPiers(Pier... piers) {
        this.piers.addAll(Arrays.asList(piers));
    }

    public List<Pier> getPiers() {
        return piers;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }
}