package org.ajeet.learnings.leetcode.easy.math;

import java.util.Stack;

public final class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(s.charAt(i) == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if(s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
