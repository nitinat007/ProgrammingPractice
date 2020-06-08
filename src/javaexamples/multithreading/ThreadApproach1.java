package javaexamples.multithreading;

import java.util.concurrent.TimeUnit;

/**
 * Author: nitinkumar
 * Created Date: 03/06/20
 * Info: Starting a thread from main method using Runnable interface.
 **/

public class ThreadApproach1 {
    public static void main(String[] args) {
        Task task = new Task();
        Thread t = new Thread(task);
        t.start();
        //sleep
        try {
            //Thread.sleep(2000);
            //alternate way to sleep this thread
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Completed main ..");
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Run..");
        subTaskMethod1();
    }

    private void subTaskMethod1() {
        System.out.println("Inside subTaskMethod1..");
        subTaskMethod2();
    }
    private void subTaskMethod2() {
        System.out.println("Inside subTaskMethod2..");
    }
}
/*
O/P: Order is not consistent
Inside Run..
Inside subTaskMethod1..
Inside subTaskMethod2..
Completed main ..
 */