package ArraysAndStrings;

import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,3};
        int[] result = getNextGreaterElement(nums);
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
}
