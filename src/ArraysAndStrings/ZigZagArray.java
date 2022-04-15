package ArraysAndStrings;

import java.util.Arrays;

public class ZigZagArray {
    public static void main(String[] args){
        int[] nums = {5,3,7,1,9,0,5,2};
        zigzagArrange(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void zigzagArrange(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0){
                if(nums[i] > nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
            else{
                if(nums[i + 1] > nums[i]){
                    swap(nums, i+1, i);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
