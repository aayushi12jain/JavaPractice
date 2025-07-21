package solutionStack;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true; // An empty string is considered valid
        }
        if(s.length() % 2 != 0) {
            return false; // Odd length cannot be valid
        }

        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c =='{' || c == '[' || c=='('){
                stack.push(c);
            }else{
                if(c==')' || stack.peek()=='(') stack.pop();
                else if(c==']' || stack.peek()=='[') stack.pop();
                else if(c=='}' || stack.peek()=='{') stack.pop();
            }
        }
        return (stack.isEmpty());
    }

}
