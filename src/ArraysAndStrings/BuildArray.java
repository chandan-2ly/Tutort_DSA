package ArraysAndStrings;

import java.util.Arrays;

public class BuildArray {
    public static void main(String[] args){
        int[] nums = {0,2,1,5,3,4};
        int[] result = buildArray(nums);
        System.out.println(Arrays.toString(result));
    }
    private static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            //System.out.println(nums[i]);
            nums[i] = nums[nums[i]];
        }

        return nums;
    }
}
