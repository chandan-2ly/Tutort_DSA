package ArraysAndStrings;

import java.util.Arrays;

public class ProductarrayExceptSelf {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int[] result = getProductArray(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getProductArray(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            result[i] = right[i] * left[i];
        }

        return result;
    }
    private static int[] getProductArray2(int[] nums) {
        int[] left = new int[nums.length];

        left[0] = 1;

        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        int rightProduct = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            left[i] = left[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return left;
    }
    private static int[] getProductArray3(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i];
        }

        int product = 1;
        for(int i = nums.length-1; i > 0; i--){
            result[i] = result[i-1] * product;
            product = nums[i] * product;
        }
        result[0] = product;
        return result;
    }
}
