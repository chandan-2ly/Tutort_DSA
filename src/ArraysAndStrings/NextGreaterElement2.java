package ArraysAndStrings;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,3};
        int[] result = getNextGreaterElement2(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getNextGreaterElement(int[] nums) {
        int[] nextGreater = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            boolean flag = false;
            for(int j = i + 1; j != i; j = (j+1)%nums.length){
                if(nums[j % nums.length] > nums[i]){
                    nextGreater[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nextGreater[i] = -1;
            }
        }

        return nextGreater;
    }

    private static int[] getNextGreaterElement2(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 2*n - 1; i >= 0; i--){
            while (!stack.empty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            if(!stack.empty())
                nextGreater[i%n] = stack.peek();
            else nextGreater[i%n] = -1;

            stack.push(nums[i%n]);
        }

        return nextGreater;
    }
}
