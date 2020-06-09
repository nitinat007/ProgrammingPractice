package javaexamples.multithreading;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerDemo {
    private Vector<String> inventory = new Vector<>();
    private final int CAPACITY = 4;


    private class Producer implements Runnable {
        private int counter = 0;

        @Override
        public void run() {
            synchronized (inventory) {
                for (int i = 0; i < 10; i++) {
                    while (inventory.size() == CAPACITY) {
                        System.out.println("Inventory Full. Waiting.. " + Thread.currentThread().getName());
                        try {
                            inventory.wait();
                            System.out.println("\nProducer woke up");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    inventory.add("Product" + counter++);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(Thread.currentThread().getName() + "-> produced. ");
                    //counter++;
                    System.out.println(" inventory is" + inventory);
                    inventory.notifyAll();
                }
            }
        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (inventory) {
                while (true) {
                    while (inventory.size() == 0) {
                        try {
                            System.out.println("Inventory Empty. Waiting.. " + Thread.currentThread().getName());
                            inventory.wait();
                            System.out.println("\nConsumer woke up. ");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(Thread.currentThread().getName() + "-> Consumed. ");
                    inventory.remove(0);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("inventory is " + inventory);
                    inventory.notifyAll();

                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerDemo producerConsumerDemo = new ProducerConsumerDemo();
        Thread consumerThread = new Thread(producerConsumerDemo.new Consumer(), "consumerThread");
        Thread producerThread = new Thread(producerConsumerDemo.new Producer(), "producerThread");
        consumerThread.start();
        producerThread.start();

    }

}
//Improvement needed. Check if producer & consumer can come one after another

/*
O/P
Inventory Empty. Waiting.. consumerThread
producerThread-> produced.  inventory is[Product0]
producerThread-> produced.  inventory is[Product0, Product1]
producerThread-> produced.  inventory is[Product0, Product1, Product2]
producerThread-> produced.  inventory is[Product0, Product1, Product2, Product3]
Inventory Full. Waiting.. producerThread

Consumer woke up.
consumerThread-> Consumed. inventory is [Product1, Product2, Product3]
consumerThread-> Consumed. inventory is [Product2, Product3]
consumerThread-> Consumed. inventory is [Product3]
consumerThread-> Consumed. inventory is []
Inventory Empty. Waiting.. consumerThread

Producer woke up
producerThread-> produced.  inventory is[Product4]
producerThread-> produced.  inventory is[Product4, Product5]
producerThread-> produced.  inventory is[Product4, Product5, Product6]
producerThread-> produced.  inventory is[Product4, Product5, Product6, Product7]
Inventory Full. Waiting.. producerThread

Consumer woke up.
consumerThread-> Consumed. inventory is [Product5, Product6, Product7]
consumerThread-> Consumed. inventory is [Product6, Product7]
consumerThread-> Consumed. inventory is [Product7]
consumerThread-> Consumed. inventory is []
Inventory Empty. Waiting.. consumerThread

Producer woke up
producerThread-> produced.  inventory is[Product8]
producerThread-> produced.  inventory is[Product8, Product9]

Consumer woke up.
consumerThread-> Consumed. inventory is [Product9]
consumerThread-> Consumed. inventory is []
Inventory Empty. Waiting.. consumerThread
 */
