package javaexamples.multithreading;

/**
 * Author: nitinkumar
 * Created Date: 03/06/20
 * Info: Setting priority,Naming and joining
 **/
public class ThreadOperations {
    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority());
        Thread t1 = new Thread(new MyEmailSenderTask());
        Thread t2 = new Thread(new MyWebCrawlerTask());
        t1.setName("emailThread");
        t2.setName("webCrawlerThread");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

        try {
            t2.join(); //main thread stays alive until t2 is alive
            // t2.join(1); //main thread waits for 1 milli sec for t2 to die
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed main ..");
    }
}

class MyEmailSenderTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" Running .. " + Thread.currentThread().getName() + " of priority " + Thread.currentThread().getPriority());
            if (i == 6) {
                Thread.yield(); // signalling thread scheduler to give other threads chance to run. Upto thread scheduler to accept/reject this hint
            }
        }
    }
}

class MyWebCrawlerTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" Running .. " + Thread.currentThread().getName() + " of priority " + Thread.currentThread().getPriority());
        }
    }
}
/*

Main thread name: main priority: 5
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. webCrawlerThread of priority 1
 Running .. webCrawlerThread of priority 1
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
 Running .. webCrawlerThread of priority 1
 Running .. emailThread of priority 10
Completed main ..
 Running .. emailThread of priority 10
 */
