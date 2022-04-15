package ArraysAndStrings;

import java.util.Arrays;

public class Right_LeftMaximum {
    public static void main(String[] args){
        int[] nums = {3,5,1,6,9,4};
        int[] rightMaxArray = getRightMaxArray2(nums);
        int[] leftMaxArray = getLeftMaxArray(nums);
        System.out.println("Right Max Array "+ Arrays.toString(rightMaxArray));
        System.out.println("Left Max Array "+ Arrays.toString(leftMaxArray));

    }

    private static int[] getRightMaxArray(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = -1;
        int rightMax = nums[nums.length - 1];

        for(int i = nums.length -2; i >= 0; i--){
            result[i] = rightMax;
            if(nums[i] > rightMax)
                rightMax = nums[i];
        }
        return result;
    }
    private static int[] getRightMaxArray2(int[] nums) {
        int[] result = new int[nums.length];

        int rightMax = nums[nums.length - 1];
        nums[nums.length - 1] = -1;

        for(int i = nums.length -2; i >= 0; i--){
            int temp = nums[i];
            result[i] = rightMax;
            if(nums[i] > rightMax)
                rightMax = nums[i];
        }
        return result;
    }

    private static int[] getLeftMaxArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = -1;
        int leftMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            result[i] = leftMax;
            if(nums[i] > leftMax)
                leftMax = nums[i];
        }
        return result;
    }
}
