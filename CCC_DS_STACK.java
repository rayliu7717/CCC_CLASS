import java.io.*;
import java.util.*;
public class CCC_DS_STACK {
    /*
    Stack is a linear data structure that follows a particular order in which the operations are performed.
    The order may be LIFO(Last In First Out) or FILO(First In Last Out).
    Stack<E> stack = new Stack<E>();
     */

    public static void main(String[] args) {
        // Default initialization of Stack
        Stack stack1 = new Stack();

        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements
        stack1.push(1);
        stack1.push(2);

        stack2.push("Hello");
        stack2.push("World");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);

        System.out.println("The element at the top of the"
                + " stack is: " + stack1.peek());

        // Removing elements using pop() method
        System.out.println("Popped element: "
                + stack1.pop());
        System.out.println("The element at the top of the"
                + " stack is: " + stack1.peek());
    }
    /* sample
    leetcode #20 Valid Parentheses
    https://leetcode.com/problems/valid-parentheses/
     */
    static public boolean isValid(String s) {
        // Stack to store left character
        Stack<Character> leftChars = new Stack<>();
        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == '(' || c == '{' || c == '[') {
                leftChars.push(c);
            }
            // If right symbol is encountered
            else if (c == ')' && !leftChars.isEmpty() && leftChars.peek() == '(') {
                leftChars.pop();
            } else if (c == '}' && !leftChars.isEmpty() && leftChars.peek() == '{') {
                leftChars.pop();
            } else if (c == ']' && !leftChars.isEmpty() && leftChars.peek() == '[') {
                leftChars.pop();
            }
            // If none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftChars.isEmpty();
    }

    /* homework
    leetcode 735. Asteroid Collision
    https://leetcode.com/problems/asteroid-collision/
    739. Daily Temperatures
    https://leetcode.com/problems/daily-temperatures/
     */

}