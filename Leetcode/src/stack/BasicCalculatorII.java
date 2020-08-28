package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 227. Basic Calculator II
// Medium

// 1528

// 266

// Add to List

// Share
// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// Example 1:

// Input: "3+2*2"
// Output: 7
// Example 2:

// Input: " 3/2 "
// Output: 1
// Example 3:

// Input: " 3+5 / 2 "
// Output: 5
// Note:

// You may assume that the given expression is always valid.
// Do not use the eval built-in library function.
// Accepted
// 193,604
// Submissions
// 522,885

public class BasicCalculatorII {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int start = i;
                while(Character.isDigit(c)) {
                    i++;
                    if(i >= s.length()) break;
                    c = s.charAt(i);
                }
                num = Integer.valueOf(s.substring(start, i));
                i--;
                if(sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
            } else if(c != ' ') {
                sign = c;
            }
            
        }
        int res = 0;
        for(int item: stack) {
            res += item;
        }
        return res;
    }
}