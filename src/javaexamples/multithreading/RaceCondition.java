package javaexamples.multithreading;

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);
        //user1 & user2 have joint account in the bank. Both try to withdraw 75
        Thread t1 = new Thread(task, "user1");
        Thread t2 = new Thread(task, "user2");
        t1.start();
        t2.start();
    }
}

class BankAccount implements Runnable {

    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread running...");
        withdraw(75);
        if (balance < 0) {
            System.out.println("Overdrawn.. Balance is " + balance);
        }
    }

    private void withdraw(int x) {
        synchronized (this) { //alternatively put synchronized keyword in method declaration
            if (balance > x) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is withdrawing " + x + " . Balance is " + balance);
                balance -= x;
                System.out.println("Thread " + Thread.currentThread().getName() + " has Withdrawn " + x + " . Now balance is " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + ": You don't have sufficient balance :(");
            }
        }
    }
}
/*
O/P (without synchronized keyword for withdraw method)
user1 thread running...
user2 thread running...
Thread user1 is withdrawing 75 . Balance is 100
Thread user2 is withdrawing 75 . Balance is 100
Thread user1 has Withdrawn 75 . Now balance is 25
Thread user2 has Withdrawn 75 . Now balance is -50
Overdrawn.. Balance is -50
Overdrawn.. Balance is -50


O/P (with synchronized block/ keyword for withdraw method). Only one of the user will withdraw
user2 thread running...
user1 thread running...
Thread user2 is withdrawing 75 . Balance is 100
Thread user2 has Withdrawn 75 . Now balance is 25
user1: You don't have sufficient balance :(
 */