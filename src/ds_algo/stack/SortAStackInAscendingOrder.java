package ds_algo.stack;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 23/01/21
 * Info: Given a stack, sort the stack in ascending order from bottom to top.
 **/

public class SortAStackInAscendingOrder {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(22);
        stack.push(25);
        stack.push(11);
        stack.push(7);
        stack.push(19);
        printStackTopToBottom(stack);
        System.out.println("\n--- Sorting ---");
        sortStack(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!stack1.isEmpty() && stack1.peek() < top) {
                stack.push(stack1.pop());
            }
            stack1.push(top);
        }
        printStackTopToBottom(stack1);
    }

    private static void printStackTopToBottom(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            printStackTopToBottom(stack);
            System.out.print(top + " ");
            stack.push(top);
        }
    }
}
/*
O/P:
22 25 11 7 19
--- Sorting ---
25 22 19 11 7
 */