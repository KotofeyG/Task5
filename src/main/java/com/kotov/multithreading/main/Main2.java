package com.kotov.multithreading.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) {

        C.A1 a1 = C.cc.new A1();
        a1.start();
//        A a = new A();
//        a.start();
        B b = new B();
        b.start();
    }
}

class A extends Thread {
    @Override
    public void run() {
        C c = C.cc;
        try {
            c.d();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        C c = C.cc;
        try {
            c.c();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C {
    static C cc = new C();
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public void c() throws InterruptedException {
        lock.lock();
        System.out.println("в с");
        condition1.signalAll();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("после с");
        lock.unlock();
    }

    public void d() throws InterruptedException {
        lock.lock();
        System.out.println("в d");
        condition1.await();
        TimeUnit.SECONDS.sleep(4);
        System.out.println("после d");
        lock.unlock();
    }

    public class A1 extends Thread {
        @Override
        public void run() {
            C c = C.cc;
            try {
                c.d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}