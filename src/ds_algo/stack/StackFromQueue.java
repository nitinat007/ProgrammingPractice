package ds_algo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: nitinkumar
 * Created Date: 10/01/21
 * Info: Implement a stack using a queue
 * Approach: Can be implemented in two ways. 1. Making push operation costly. 2.Making pop operation costly.
 **/

//using pop costly approach
public class StackFromQueue {
    Queue<Integer> queue = new LinkedList<>(); //or new PriorityQueue<>()

    public static void main(String[] args) {
        StackFromQueue stackFromQueue = new StackFromQueue();
        stackFromQueue.pop();
        stackFromQueue.push(11);
        stackFromQueue.push(12);
        stackFromQueue.push(13);
        stackFromQueue.top();
        stackFromQueue.pop();
        stackFromQueue.top();
        stackFromQueue.pop();
        stackFromQueue.top();
        stackFromQueue.pop();
        stackFromQueue.top();
        stackFromQueue.pop();
    }

    public void push(int i) {
        System.out.println("Pushing " + i);
        queue.add(i);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.print("Queue is empty. ");
        }
        queue.add(null);
        Integer temp = queue.poll();
        while (queue.peek() != null) {
            queue.add(temp);
            temp = queue.poll();
        }
        if (queue.peek() == null) {
            queue.poll();
        }
        System.out.println("Popped " + temp);
    }

    public void top() {
        int i = 0;
        Integer top = queue.peek();
        while (i < queue.size()) {
            top = queue.poll();
            queue.add(top);
            i++;
        }
        System.out.println("top is " + top);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
/*
O/P:
Queue is empty. Popped null
Pushing 11
Pushing 12
Pushing 13
top is 13
Popped 13
top is 12
Popped 12
top is 11
Popped 11
top is null
Queue is empty. Popped null
 */