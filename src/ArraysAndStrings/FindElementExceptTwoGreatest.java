package ArraysAndStrings;

import java.util.Arrays;

public class FindElementExceptTwoGreatest {
    public static void main(String[] args){
        int[] nums = {7, -2, 3, 4, 9, -1};
        int[] result = getGreatestElement(nums);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] getGreatestElement(int[] nums){
        int[] result = new int[nums.length-2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            result[i] = nums[i];
        }
        return result;
    }
}
