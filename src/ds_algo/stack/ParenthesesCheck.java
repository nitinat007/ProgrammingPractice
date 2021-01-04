package ds_algo.stack;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Given string contains only the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’. Check if string containing parentheses which is extracted from mathematical expression is valid
 **/

public class ParenthesesCheck {
    public static void main(String[] args) {
        String str1 = "[{}(){()}]"; //valid
        String str2 = "[{})(]"; //invalid
        System.out.println(parenthesesChecker(str1));
        System.out.println(parenthesesChecker(str2));
    }

    private static boolean parenthesesChecker(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
/*
O/P:
true
false
 */