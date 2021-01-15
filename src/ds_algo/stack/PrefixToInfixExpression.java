package ds_algo.stack;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 15/01/21
 * Info: Given a prefix expression, convert it ti infix expression
 **/

public class PrefixToInfixExpression {
    public static void main(String[] args) {
        String prefix = "AB+CD-*";
        System.out.println(convertPrefixToInfix(prefix));
    }

    private static String convertPrefixToInfix(String exp) {
        Stack<String> stack = new Stack();
        for (char c : exp.toCharArray()) {
            if (isAlphabet(c)) {
                stack.push(String.valueOf(c));
            } else {
                try {
                    String exp1 = stack.pop();
                    String exp2 = stack.pop();
                    stack.push("(" + exp2 + c + exp1 + ")");
                } catch (Exception ex) {
                    System.out.println("Input expression is not a Prefix expn. Exiting..");
                    return "";
                }
            }
        }
        return stack.peek();
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
/*
O/P:
((A+B)*(C-D))
 */