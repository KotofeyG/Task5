package com.kotov.multithreading.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {
    private final ReentrantLock pierLock = new ReentrantLock();
    private final Condition shipMaintenance = pierLock.newCondition();
    private final Condition shipExpectation = pierLock.newCondition();
    private ContainerCrane crane = new ContainerCrane();
    private String name;
    private Ship currentShip;

    public Pier(String name) {
        this.name = name;
        crane.start();
    }

    public void takeShip(Ship arrivedShip) {
        if (currentShip != null || !pierLock.tryLock()) {
            return;
        }
        try {
            currentShip = arrivedShip;
            System.out.println("Корабль №" + currentShip.getShipId() + " швартуется к " + name + "...");
            TimeUnit.SECONDS.sleep(2);
            shipExpectation.signalAll();
            System.out.println("Корабль №" + currentShip.getShipId() + " готов к разгрузке.");
            TimeUnit.SECONDS.sleep(1);
            shipMaintenance.await();
            System.out.println("Корабль №" + currentShip.getShipId() + " уплывает...");
            currentShip = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pierLock.unlock();
        }
    }

    public void unloadContainers() {
        pierLock.lock();
        Storehouse storehouse = Port.getInstance().getStorehouse();
        try {
            while (true) {
                if (this.isEmpty() || currentShip.isEmpty()) {
                    TimeUnit.SECONDS.sleep(1);
                    if (currentShip != null) {
                        System.out.println("Разгрузка корабля №" + currentShip.getShipId() + " завершена.");
                    }
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Ожидание нового корабля для обслуживания...");
                    shipMaintenance.signalAll();
                    if (!shipExpectation.await(10, TimeUnit.SECONDS)) {
                        break;
                    }
                    System.out.println("Разгрузка корабля №" + currentShip.getShipId() + "...");
                }
                TimeUnit.SECONDS.sleep(1);
                crane.liftContainer(currentShip.pollLast());
                storehouse.add(crane.putContainer());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pierLock.unlock();
        }
    }

    public boolean isEmpty() {
        return currentShip == null;
    }

    public class ContainerCrane extends Thread {
        Container container;

        public ContainerCrane() {
        }

        public void liftContainer(Container container) {
            if (this.container == null) {
                this.container = container;
            }
        }

        public Container putContainer() {
            Container puttingContainer = container;
            container = null;
            return puttingContainer;
        }

        @Override
        public void run() {
            unloadContainers();
        }
    }
}