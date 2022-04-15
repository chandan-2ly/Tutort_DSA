package ArraysAndStrings;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args){
        int[] nums = {2, 3, 4, 5, 6};
        int[] result = getProductArray(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getProductArray2(int[] nums) {
        int[] result = new int[nums.length];
        if(nums.length <= 1) return nums;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                result[i] = nums[i] * nums[i+1];
            }
            else if(i == nums.length - 1){
                result[i] = nums[i] * nums[i-1];
            }
            else {
                result[i] = nums[i - 1] * nums[i + 1];
            }
        }
        return result;
    }
    private static int[] getProductArray(int[] nums) {
        if(nums.length <= 1) return nums;
        int prev = nums[0];
        for(int i = 0; i < nums.length - 1; i++){
            int temp = nums[i];
            nums[i] = prev * nums[i + 1];
            prev = temp;
        }
        nums[nums.length - 1] = prev * nums[nums.length - 1];
        return nums;
    }
}
