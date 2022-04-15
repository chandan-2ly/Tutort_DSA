package ArraysAndStrings;

import java.util.Arrays;

public class ShiftArrayElements {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        rightShift(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {1,2,3,4,5};
        leftShift(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    private static void rightShift(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = -1;
    }

    private static void leftShift(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length - 1] = -1;
    }
}
