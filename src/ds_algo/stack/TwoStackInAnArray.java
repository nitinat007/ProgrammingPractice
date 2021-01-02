package ds_algo.stack;

/**
 * Author: nitinkumar
 * Created Date: 17/12/20
 * Info: Implement Two Stacks In An Array. There should be no stackOverflow in any of the stack if there is spare left in the array
 **/

public class TwoStackInAnArray {
    private int[] arrayForStack;
    private int topStack1;
    private int topStack2;

    public TwoStackInAnArray(int size) {
        this.arrayForStack = new int[size];
        topStack1 = -1;
        topStack2 = arrayForStack.length;
    }

    private void push(int val, int stackNumber) {
        if (topStack1 + 1 == topStack2) {
            System.out.println("Stack Overflow. Can't push " + val + " in stack " + stackNumber);
            return;
        }
        if (stackNumber == 1) {
            arrayForStack[++topStack1] = val;
        } else {
            arrayForStack[--topStack2] = val;
        }
        System.out.println("Pushed " + val + " to stack " + stackNumber);
        //printArray();
    }

    private void pop(int stackNumber) {
        if (stackNumber == 1 && topStack1 == -1) {
            System.out.println("Can't pop. Stack 1 is empty");
        } else if (stackNumber == 2 && topStack2 == arrayForStack.length) {
            System.out.println("Can't pop. Stack 2 is empty");
        } else {
            if (stackNumber == 1) {
                System.out.println("Popped " + arrayForStack[topStack1--] + " from stack " + stackNumber);
            } else {
                System.out.println("Popped " + arrayForStack[topStack2++] + " from stack " + stackNumber);
            }
        }
        // printArray();
    }

    private void printArray() {
        System.out.println("Array after operation : ");
        for (int a : arrayForStack) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        TwoStackInAnArray stack = new TwoStackInAnArray(10);
        stack.push(22, 1);
        stack.push(50, 2);
        stack.push(23, 1);
        stack.push(52, 2);
        stack.push(24, 1);
        stack.push(53, 2);
        stack.push(25, 1);
        stack.push(54, 2);
        stack.push(26, 1);
        stack.push(55, 2);
        stack.push(27, 1);//should throw stackOverflow Exception
        stack.pop(1);
        stack.pop(1);
        stack.pop(1);
        stack.pop(1);
        stack.pop(2);
        stack.pop(1);
        stack.pop(1); //should throw stackEmpty Exception

    }

}
/*
O/P:
Pushed 22 to stack 1
Pushed 50 to stack 2
Pushed 23 to stack 1
Pushed 52 to stack 2
Pushed 24 to stack 1
Pushed 53 to stack 2
Pushed 25 to stack 1
Pushed 54 to stack 2
Pushed 26 to stack 1
Pushed 55 to stack 2
Stack Overflow. Can't push 27 in stack 1
Popped 26 from stack 1
Popped 25 from stack 1
Popped 24 from stack 1
Popped 23 from stack 1
Popped 55 from stack 2
Popped 22 from stack 1
Can't pop. Stack 1 is empty
 */