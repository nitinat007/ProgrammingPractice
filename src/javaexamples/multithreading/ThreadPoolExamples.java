package javaexamples.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExamples {
    public static void main(String[] args) {

        FactorialCalculationWork task1 = new FactorialCalculationWork(5);
        FactorialCalculationWork task2 = new FactorialCalculationWork(6);
        FactorialCalculationWork task3 = new FactorialCalculationWork(7);
        FactorialCalculationWork task4 = new FactorialCalculationWork(14);

        //Using ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future> futures = new ArrayList<>();
        futures.add(executorService.submit(task1));
        futures.add(executorService.submit(task2));
        futures.add(executorService.submit(task3));
        futures.add(executorService.submit(task4));

        printOutput(futures);
        executorService.shutdown();
        System.out.println();

        //Using ExecutorCompletionService
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        CompletionService executorCompletionService = new ExecutorCompletionService<>(executorService1);
        List<Future> futures1 = new ArrayList<>();
        futures1.add(executorCompletionService.submit(task1));
        futures1.add(executorCompletionService.submit(task2));
        futures1.add(executorCompletionService.submit(task3));
        futures1.add(executorCompletionService.submit(task4));

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(executorCompletionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //printOutput(futures1); // Will print results in the order of submitted task
        executorService1.shutdown();

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

/*
O/P

120
720
5040
1278945280

120
5040
1278945280
720
 */