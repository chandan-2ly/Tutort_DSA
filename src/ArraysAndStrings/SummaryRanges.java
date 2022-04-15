package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args){
        int[] nums = {0,2,3,4,6,8};
        List<String> result = getSummaryRange(nums);
        System.out.println(result);
    }

    private static List<String> getSummaryRange(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        int i = 1;
        while (i < nums.length){
            if((end + 1) == nums[i]){
                end = nums[i];
            }
            else{
                String temp = Integer.toString(start);
                if(start != end)
                    temp += "->" + end;
                result.add(temp);
                start = nums[i];
                end = nums[i];
            }
            i++;
        }
        String temp = Integer.toString(start);
        if(start != end)
            temp += "->" + end;
        result.add(temp);
        return result;
    }
}
