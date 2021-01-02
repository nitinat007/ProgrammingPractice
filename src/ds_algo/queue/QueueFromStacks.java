package ds_algo.queue;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 17/12/20
 * Info: Make a Queue From Two Stacks.
 * Can be implemented in two ways. One by making enQueue Operation costly. Other by making deQueue costly.
 **/

//Approach: making enQueue costly
public class QueueFromStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        QueueFromStacks queue = new QueueFromStacks();
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println("deQueued: " + queue.deQueue());
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println("deQueued: " + queue.deQueue());
        System.out.println("deQueued: " + queue.deQueue());
        System.out.println("deQueued: " + queue.deQueue());
        System.out.println("deQueued: " + queue.deQueue());
        System.out.println("deQueued: " + queue.deQueue()); // deQueue empty queue
    }

    private int deQueue() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return -1;
    }

    private void enQueue(int val) {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(val);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("enQueued: " + val);
    }

}

/*
O/P:
enQueued: 1
enQueued: 2
deQueued: 1
enQueued: 3
enQueued: 4
enQueued: 5
deQueued: 2
deQueued: 3
deQueued: 4
deQueued: 5
deQueued: -1
 */