package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = getTwoSumArray(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getTwoSumArray(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    
}
