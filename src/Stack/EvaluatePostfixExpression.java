package Stack;

import java.util.Stack;

public class EvaluatePostfixExpression {
    public static void main(String[] args){
        String[] token = {"2","1","+","3","*"};
        int result = getEvaluatedValue(token);
        System.out.println(result);
    }

    private static int getEvaluatedValue(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);

        Stack<String> stack = new Stack<>();
        for(String s : tokens){
            switch (s){
                case "+":
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int c = b + a;
                    stack.push(String.valueOf(c));
                    break;
                case "-":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    c = b - a;
                    stack.push(String.valueOf(c));
                    break;
                case "*":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    c = b * a;
                    stack.push(String.valueOf(c));
                    break;
                case "/":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    c = b / a;
                    stack.push(String.valueOf(c));
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
