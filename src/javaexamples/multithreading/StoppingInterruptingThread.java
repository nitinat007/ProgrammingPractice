package javaexamples.multithreading;
/**
 * Author: nitinkumar
 * Created Date: 03/06/20
 * Info: Demo shows stopping and interrupting thread and also the usage of AtomicBoolean (instead of volatile boolean variable)
 **/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class StoppingInterruptingThread {
    private static volatile boolean running = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t12 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("setting running to true for t12");
                running = true;
                while (running) {
                    System.out.println("running.. t12");
                }
            }

        });
        t12.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("setting running to false for t12");
        running = false;
        TimeUnit.MILLISECONDS.sleep(1);

        System.out.println();
        Thread1 t13 = new Thread1();
        t13.start();
        TimeUnit.MILLISECONDS.sleep(1);
        t13.interrupt();

        System.out.println();
        Thread2 t14 = new Thread2();
        t14.start();
        TimeUnit.MILLISECONDS.sleep(1);
        t14.interrupt();

        System.out.println();
        Thread t15 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running.. t15");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.. t15");
                    //e.printStackTrace();
                }

            }
        });
        t15.start();
        TimeUnit.SECONDS.sleep(1);
        t15.interrupt(); //This will interrupt the sleeping thread

    }

}

class Thread1 extends Thread {
    private static volatile boolean running = false;

    public void run() {
        running = true;
        while (running)
            System.out.println("Running.. Thread1"); //This might not work if thread is in WAITING. AtomicBoolean is better approach
    }

    @Override
    public void interrupt() { //instead of overriding , we can have different method like stopThread()
        // Thread.currentThread().interrupt(); this did not work
        running = false;
        System.out.println("Interrupting.. Thread1");
    }

}

class Thread2 extends Thread {
    private static AtomicBoolean running = new AtomicBoolean(false);

    public void run() {
        running.set(true);
        while (running.get())
            System.out.println("Running.. Thread2");
    }

    @Override
    public void interrupt() {
        running.set(false);
        System.out.println("Interrupting.. Thread2");
    }

}
/*
setting running to true for t12
running.. t12
running.. t12
..
running.. t12
setting running to false for t12
running.. t12

Running.. Thread1
Running.. Thread1
..
Running.. Thread1
Interrupting.. Thread1

Running.. Thread2
Running.. Thread2
..
Running.. Thread2
Interrupting.. Thread2

running.. t15
Interrupted.. t15
 */