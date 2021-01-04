package ds_algo.stack;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Design a Stack With getMinValue() operation in O(1) time and space complexity
 * <p>
 * "Important"
 * Logic: keep track of minVal variable while pushing and popping element in stack. while pushing x, check if x is less than minVal. If so then push (2*x - minVal) and update minVal to x.
 * Else push x. While popping check if popped element (say x is popped) is less than minVal. If so then return min value and update min to (2*minVal - x). Else return x.
 **/

public class StackWithGetMinMethod {
    Stack<Integer> stack;
    int minVal = 0;

    public StackWithGetMinMethod() {
        this.stack = new Stack();
        this.minVal = 0;
    }

    public static void main(String[] args) {
        StackWithGetMinMethod s = new StackWithGetMinMethod();
        s.push(7);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(1);
        s.push(5); //check once for repeated number
        s.push(8);
        System.out.println("top: " + s.top());
        System.out.println("minVal: " + s.getMinVal());
        System.out.println("popped: " + s.pop());
        System.out.println("top: " + s.top());
        System.out.println("minVal: " + s.getMinVal());
        System.out.println("popped: " + s.pop());
        System.out.println("top: " + s.top());
        System.out.println("minVal: " + s.getMinVal());
        System.out.println("popped: " + s.pop());
        System.out.println("top: " + s.top());
        System.out.println("minVal: " + s.getMinVal());
        System.out.println("popped: " + s.pop());
        System.out.println("top: " + s.top());
        System.out.println("minVal: " + s.getMinVal());
        //also check for repeated same number push
    }

    private void push(int x) {
        System.out.println("pushing " + x);
        if (stack.isEmpty()) {
            stack.push(x);
            minVal = x;
        } else {
            if (x < minVal) {
                stack.push(2 * x - minVal);
                minVal = x;
            } else {
                stack.push(x);
            }
        }
    }

    private int top() {
        if (stack.isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }
        if (stack.peek() < minVal) {
            return 2 * minVal - stack.peek();
        } else {
            return stack.peek();
        }
    }

    private int pop() {
        if (stack.isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }
        int poppedVal = stack.pop();
        if (poppedVal < minVal) {
            int toReturn = minVal;
            minVal = 2 * minVal - poppedVal;
            return toReturn;
        } else {
            return poppedVal;
        }
    }

    private int getMinVal() {
        return minVal;
    }
}
/*
O/P:
pushing 7
pushing 2
pushing 3
pushing 4
pushing 1
pushing 5
pushing 8
top: 8
minVal: 1
popped: 8
top: 5
minVal: 1
popped: 5
top: 2
minVal: 1
popped: 1
top: 4
minVal: 2
popped: 4
top: 3
minVal: 2
 */