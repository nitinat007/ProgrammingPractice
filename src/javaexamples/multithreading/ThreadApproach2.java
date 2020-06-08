package javaexamples.multithreading;

/**
 * Author: nitinkumar
 * Created Date: 03/06/20
 * Info: Starting a thread using Thread class.
 **/

public class ThreadApproach2 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        System.out.println("Completed main ..");
    }
}

class MyThread extends Thread{

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
