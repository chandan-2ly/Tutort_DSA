package Stack;

import javafx.util.Pair;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
public class OnlineStockSpan {
    public static void main(String[] args){
        StockSpanner obj = new StockSpanner();
        int[] nums = {31, 48, 59, 69, 79};
        for (int num : nums) {
            System.out.println(obj.next(num));
        }
    }
}
class StockSpanner {
    Stack<Pair<Integer, Integer>> stack;
    int i;
    public StockSpanner() {
        stack = new Stack<>();
        i = -1;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().getKey() <= price){
            stack.pop();
        }
        if(stack.isEmpty()){
            i++;
            int ans = i - (-1);
            stack.push(new Pair<>(price, i));
            return ans;
        }
        else{
            int ans = ++i - stack.peek().getValue();
            stack.push(new Pair<>(price, i));
            return ans;
        }
    }
}
