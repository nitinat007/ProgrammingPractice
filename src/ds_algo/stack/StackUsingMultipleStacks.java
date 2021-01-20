package ds_algo.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 20/01/21
 * Info: Implement a stack using a list of stacks.
 * Image a situation where we have a limitation on size of a stack (say a stack can contain maximum N elements) and we have to create a stack
 * which can hold much more than N elements (say 5*N + x elements). Create an implementation of stack supporting all the operations of a stack.
 * So, basically instead of one stack we have to maintain a list of stack. This implementation of stack should support push(), pop(), top(), size() operation.
 **/

public class StackUsingMultipleStacks {
    private ArrayList<Stack<Integer>> stackList;
    private int maxSizeOfStack;

    public StackUsingMultipleStacks(ArrayList<Stack<Integer>> stackList, int maxSizeOfStack) {
        this.stackList = stackList;
        this.maxSizeOfStack = maxSizeOfStack;
    }

    public void push(int x) {
        System.out.println("pushing: " + x);
        int currentStackNumber = this.getLastStackNumber(); //currentStackNumber starts from 0
        if (currentStackNumber == -1) { //stackList is empty. Create a stack. push X and add stack to stackList
            Stack<Integer> stack = new Stack<>();
            stack.push(x);
            stackList.add(stack);
        } else if (stackList.get(currentStackNumber).size() == maxSizeOfStack) {  //stackList is not empty but last stack in the list is full. Create a new stack. push X and add stack to stackList
            Stack<Integer> stack = new Stack<>();
            stack.push(x);
            stackList.add(stack);
        } else { //push X to last stack in the stackList
            stackList.get(currentStackNumber).push(x);
        }

    }

    private int getLastStackNumber() {
        int sizeOfStackList = stackList.size();
        return sizeOfStackList - 1;
    }

    public int pop() {
        int currentStackNumber = this.getLastStackNumber();
        if (currentStackNumber == -1) {
            System.out.print("Empty Stack. Can't pop element. Returning -1. ");
            return -1;
        }
        int toReturn = stackList.get(currentStackNumber).pop();
        if (stackList.get(currentStackNumber).size() == 0) { //remove stack from list if it is empty after pop.
            stackList.remove(currentStackNumber);
        }
        return toReturn;
    }

    public int top() {
        int currentStackNumber = this.getLastStackNumber();
        if (currentStackNumber == -1) {
            System.out.print("Empty Stack. No top exists. Returning -1. ");
            return -1;
        }
        return stackList.get(currentStackNumber).peek();
    }

    public int size() {
        return (stackList.size() - 1) * maxSizeOfStack + stackList.get(getLastStackNumber()).size();
    }

    public static void main(String[] args) {

        StackUsingMultipleStacks stack = new StackUsingMultipleStacks(new ArrayList<>(), 3);
        System.out.println("popped : " + stack.pop());
        System.out.println("top: " + stack.top());
        stack.push(1);
        stack.push(2);
        System.out.println("popped : " + stack.pop());
        System.out.println("top: " + stack.top());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("popped : " + stack.pop());
        System.out.println("top: " + stack.top());
        System.out.println("size: " + stack.size());
        System.out.println("popped : " + stack.pop());
        System.out.println("top: " + stack.top());
        System.out.println("size: " + stack.size());

    }
}
/*
O/P:
Empty Stack. Can't pop element. Returning -1. popped : -1
Empty Stack. No top exists. Returning -1. top: -1
pushing: 1
pushing: 2
popped : 2
top: 1
pushing: 3
pushing: 4
pushing: 5
pushing: 6
popped : 6
top: 5
size: 4
popped : 5
top: 4
size: 3
 */
