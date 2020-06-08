package javaexamples.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true); // try with false as well

    private static StringBuilder StoredValues = new StringBuilder("");

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Reader(), "ReadThread-1");
        Thread t2 = new Thread(new Reader(), "ReadThread-2");
        Thread t3 = new Thread(new WriterOdd(), "OddWriterThread");
        Thread t4 = new Thread(new WriterEven(), "EvenWriterThread");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static class Reader implements Runnable {
        public void run() {
            Lock readLock = reentrantReadWriteLock.readLock();
            for (int i = 0; i < 5; i++) {
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + " read " + StoredValues);
                readLock.unlock();
            }
        }
    }

    static class WriterOdd implements Runnable {

        public void run() {
            for (int i = 1; i <= 5; i += 2) {
                try {
                    reentrantReadWriteLock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + " is writing");
                    StoredValues = StoredValues.append(" " + i);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
        }
    }

    static class WriterEven implements Runnable {

        public void run() {
            for (int i = 2; i <= 5; i += 2) {
                try {
                    reentrantReadWriteLock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + " is writing");
                    StoredValues = StoredValues.append(" " + i);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
        }
    }
}
/*
O/P
ReadThread-1 read
ReadThread-2 read
EvenWriterThread is writing
OddWriterThread is writing
ReadThread-1 read  2 1
ReadThread-2 read  2 1
EvenWriterThread is writing
OddWriterThread is writing
ReadThread-1 read  2 1 4 3
ReadThread-2 read  2 1 4 3
OddWriterThread is writing
ReadThread-1 read  2 1 4 3 5
ReadThread-2 read  2 1 4 3 5
ReadThread-1 read  2 1 4 3 5
ReadThread-2 read  2 1 4 3 5
 */