package Stack;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/min-stack/
//https://leetcode.com/problems/min-stack/
public class GetMin {
    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(9);
        System.out.println(stack.getMin());
        stack.push(8);
        System.out.println(stack.getMin());
        stack.push(7);
        System.out.println(stack.getMin());
        stack.push(6);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
class MinStack{
    List<Integer> list;
    int min = -1;
    public MinStack(){
        list = new ArrayList<>();
    }
    public void push(int x) {
        if(list.size() == 0){
            list.add(x);
            min = x;
            return;
        }
        else if(x <= min){
            list.add(min);
            min = x;
        }
        list.add(x);
    }

    public void pop() {
        if(list.size() > 0 && list.remove(list.size()-1) == min){
            if(list.size() > 0)
                min = list.remove(list.size()-1);
            else
                min = -1;
        }
    }

    public int top() {
        if(list.size() == 0)
            return -1;
        return list.get(list.size()-1);
    }

    public int getMin() {
        if(list.size() == 0)
            return -1;
        return min;
    }
}
