package Stack;

import java.util.Objects;
import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
public class BackSpaceStringCompare {
    public static void main(String[] args){
        String s = "ab#c";
        String t = "ad#c";
        boolean result = backSpaceCompare(s, t);
        System.out.println(result);
    }

    private static boolean backSpaceCompare(String s, String t) {
        String str = getFormatedString(s);
        String target = getFormatedString(t);

        return Objects.equals(str, target);
    }
    private static String getFormatedString(String s){
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == '#'){
                stack.pop();
            }
            else if(ch != '#')
                stack.push(ch);
        }

        String res = "";
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
