package javaexamples.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExamples {
    public static void main(String[] args) {

        FactorialCalculationWork task1 = new FactorialCalculationWork(5);
        FactorialCalculationWork task2 = new FactorialCalculationWork(10);
        FactorialCalculationWork task3 = new FactorialCalculationWork(12);
        FactorialCalculationWork task4 = new FactorialCalculationWork(14);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future> futures = new ArrayList<>();
        futures.add(executorService.submit(task1));
        futures.add(executorService.submit(task2));
        futures.add(executorService.submit(task3));
        futures.add(executorService.submit(task4));

        printOutput(futures);
        executorService.shutdown();

    }

    private static void printOutput(List<Future> futures) {
        for (Future future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    static class FactorialCalculationWork implements Callable {
        int number;

        public FactorialCalculationWork(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            int fact = 1;
            for (int count = number; count > 1; count--) {
                fact = fact * count;
            }
            return fact;
        }
    }
}
