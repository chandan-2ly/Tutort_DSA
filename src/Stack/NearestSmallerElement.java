package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(34,35,27,42,5,28,39,20,28));
        ArrayList<Integer> result = getPrevSmallerElem(nums);
        System.out.println(result);
    }

    private static ArrayList<Integer> getPrevSmallerElem(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(A.get(0));
        A.set(0, -1);
        for(int i = 1; i < A.size(); i++){
            int temp = A.get(i);
            while (!stack.isEmpty() && A.get(i) < stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                A.set(i, -1);
            }
            else {
                A.set(i, stack.peek());
            }
            stack.push(temp);
        }
        return A;
    }
}
