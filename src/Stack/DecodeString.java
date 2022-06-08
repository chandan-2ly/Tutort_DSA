package Stack;

import java.util.Objects;
import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public static void main(String[] args){
        String s = "2[abc]3[cd]ef";
        String result = getDecodedString(s);
        System.out.println(result);
    }

    private static String getDecodedString(String s) {
        Stack<String> stack = new Stack<>();
        int n = s.length();
        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)) {
                stack.push(String.valueOf(s.charAt(i)));
            }
            else {
                int number = 0;
                int index = i;
                int power = 0;
                while (index >= 0 && Character.isDigit(s.charAt(index))){
                    number += (s.charAt(index) - '0') * Math.pow(10, power++);
                    index--;
                }
                i = index+1;
                StringBuilder newStr = new StringBuilder();
                StringBuilder toAppend = new StringBuilder();
                stack.pop();    //pop the opening bracket
                while (!Objects.equals(stack.peek(), "]")){
                    toAppend.append(stack.pop());
                }
                stack.pop();    //pop the closing bracket
                for(int j = 0; j < number; j++){
                    newStr.append(toAppend);
                }
                stack.push(newStr.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            String str = stack.pop();
            result.append(str);
        }
        return result.toString();

    }
}
