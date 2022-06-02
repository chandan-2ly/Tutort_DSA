package Stack;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/submissions/
public class ValidParenthesis {
    public static void main(String[] args){
        String s = "(){[}]";
        boolean result = isValid(s);
        System.out.println(result);
    }

    private static boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(' :
                    stack.push(ch);
                    break;
                case ')' :
                    if(stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case '{' :
                    stack.push(ch);
                    break;
                case '}' :
                    if(stack.empty() || stack.pop() != '{')
                        return false;
                    break;
                case '[' :
                    stack.push(ch);
                    break;
                case ']' :
                    if(stack.empty() || stack.pop() != '[')
                        return false;
                    break;

            }
        }
        return stack.isEmpty();
    }
}
