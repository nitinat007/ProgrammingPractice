package javaexamples.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockingExamples {
    public static void main(String[] args) throws InterruptedException {

        WorkerJob1 worker = new WorkerJob1();
        Thread t1 = new Thread(worker, "Thread-1");
        Thread t2 = new Thread(worker, "Thread-2");
        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println();

        WorkerJob2 worker2 = new WorkerJob2();
        Thread t3 = new Thread(worker2, "Thread-3");
        Thread t4 = new Thread(worker2, "Thread-4");
        t3.start();
        t4.start();
    }

    private static class WorkerJob1 implements Runnable {
        private final ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " - 1");
                System.out.println(Thread.currentThread().getName() + " - 2");
                System.out.println(Thread.currentThread().getName() + " - 3");
            } finally {
                lock.unlock();
            }
        }
    }

    private static class WorkerJob2 implements Runnable {

        @Override
        public void run() {

            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " - 1");
                System.out.println(Thread.currentThread().getName() + " - 2");
                System.out.println(Thread.currentThread().getName() + " - 3");
            }
            /* w/o synchronized block O/P is
                Thread-3 - 1
                Thread-4 - 1
                Thread-4 - 2
                Thread-4 - 3
                Thread-3 - 2
                Thread-3 - 3

             */
        }
    }
}

/*
O/P

Thread-1 - 1
Thread-1 - 2
Thread-1 - 3
Thread-2 - 1
Thread-2 - 2
Thread-2 - 3

Thread-3 - 1
Thread-3 - 2
Thread-3 - 3
Thread-4 - 1
Thread-4 - 2
Thread-4 - 3
 */
