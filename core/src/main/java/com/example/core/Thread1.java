package com.example.core;

public class Thread1 implements Runnable {

    private int num = 100;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.num > 0) {
                System.out.println("这是第：" + this.num--);
            }
        }
    }
}
