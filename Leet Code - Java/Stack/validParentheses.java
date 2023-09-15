package Stack;

import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}'){

                if (stack.isEmpty()) {
                    return false; // Closing character without a corresponding opening character
                }

                boolean result = false;
                switch(ch){
                    case ')': result = (stack.pop() == '('); break;
                    case ']': result = (stack.pop() == '['); break;
                    case '}': result = (stack.pop() == '{'); break;
                }
                if(!result){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
