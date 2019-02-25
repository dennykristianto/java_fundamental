package com.mitrais.training.Helper;

public class ThreadExample implements Runnable {

    private Thread t;
    private String threadName;

    public ThreadExample( String name) {
        threadName = name;
        System.out.println("Creating " + threadName );
    }

    public void run() {
        System.out.println("Running " + threadName );
        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " is interrupted.");
        }
        System.out.println("Thread " + threadName + " is exiting.");
    }

    public void start () {
        System.out.println("Starting " + threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
