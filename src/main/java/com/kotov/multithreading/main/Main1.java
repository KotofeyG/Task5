package com.kotov.multithreading.main;

import com.kotov.multithreading.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Ship> ships = new ArrayList<>();

        for (int i = 0; i < 36; i++) {
            Container container1 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container2 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container3 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container4 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container5 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container6 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container7 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container8 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container9 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Container container0 = new Container(random.nextInt(15), random.nextInt(25), random.nextInt(10), random.nextInt(200));
            Ship ship = new Ship(String.valueOf(i));
            ship.offerLast(container0);
            ship.offerLast(container1);
            ship.offerLast(container2);
            ship.offerLast(container3);
            ship.offerLast(container4);
            ship.offerLast(container5);
            ship.offerLast(container6);
            ship.offerLast(container7);
            ship.offerLast(container8);
            ship.offerLast(container9);
            ships.add(ship);
        }

        Port port = Port.getInstance();
        Pier pier1 = new Pier("Пирс 1");
        Pier pier2 = new Pier("Пирс 2");
        Pier pier3 = new Pier("Пирс 3");
        Pier pier4 = new Pier("Пирс 4");
        port.setPiers(pier1, pier2, pier3, pier4);

        for (Ship ship : ships) {
            System.out.println("Next ship sailed...");
            ship.start();
        }
        System.out.println("\n\n\n\n");
        System.out.println(port.getStorehouse());
    }
}
