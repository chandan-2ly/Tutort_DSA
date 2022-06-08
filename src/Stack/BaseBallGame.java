package Stack;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args){
        String[] ops = {"5","2","C","D","+"};
        int result = callPoints(ops);
        System.out.println(result);
    }

    private static int callPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < ops.length; i++){
            String str = ops[i];
            switch (str){
                case "+":
                    String temp = stack.pop();
                    int num1 = Integer.parseInt(temp);
                    int num2 = Integer.parseInt(stack.peek());
                    stack.push(temp);
                    stack.push(String.valueOf(num1+num2));
                    break;
                case "D":
                    int num = Integer.parseInt(stack.peek());
                    stack.push(String.valueOf(2*num));
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += Integer.parseInt(stack.pop());
        }
        return sum;
    }
}
