package ArraysAndStrings;

import java.util.Arrays;

public class ReduceElementByOne {
    public static void main(String[] args){
        int N = 7;
        int[] nums = {7, 8, 3, 4, 2, 9, 5};
        int result = getLastElement(N, nums);
        System.out.println("Result is "+result);
    }

    public static int getLastElement(int N, int[] nums){
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j){
            i++;
            j--;
        }
        if(N % 2 == 0)
            return nums[i-1];       //i is already incremented by while loop
        else
            return nums[i];
    }
    //optimal approach
//    public static int getLastElement(int N, int[] nums){
//        //Arrays.sort(nums);
//        int i = 1;
//        while(N > 1){
//            if( (i % 2) == 0){
//
//            }
//            i++;
//        }
//        if(N % 2 == 0)
//            return nums[i-1];       //i is already incremented by while loop
//        else
//            return nums[i];
//    }
}
