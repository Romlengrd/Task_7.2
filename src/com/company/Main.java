package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Prop p = new Prop();
        Prop p1 = new Prop();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p1);
        t1.start();
        t2.start();
        t2.join();
        try {
            p.getProps();
        } catch (NoSuchFieldException e) {
            System.out.println("Не найден ключ");
        }

    }
}
