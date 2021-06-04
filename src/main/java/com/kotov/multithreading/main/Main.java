package com.kotov.multithreading.main;

import com.kotov.multithreading.entity.Container;
import com.kotov.multithreading.entity.Storehouse;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Container container1 = new Container(1, 2, 3, 4);
        Container container2 = new Container(5, 6, 7, 8);
        Container container3 = new Container(9, 3, 5, 7);
        Container container4 = new Container(2, 4, 6, 8);
        Container container5 = new Container(4, 7, 7, 9);
        Storehouse storehouse = new Storehouse();
        storehouse.addAll(container1, container2, container3, container4, container5);
        System.out.println(storehouse);
        System.out.println(container1);
        ArrayDeque<String> deque = new ArrayDeque<>();

    }
}
