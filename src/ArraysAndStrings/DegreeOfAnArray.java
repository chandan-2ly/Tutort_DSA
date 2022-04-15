package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/degree-of-an-array/
public class DegreeOfAnArray {
    public static void main(String[] args){
        int[] nums =  {1,2,1};
        int result = getMinimumSubArrayLengthOfSameDegreeInArray(nums);
        System.out.println(result);
    }

    private static int getMinimumSubArrayLengthOfSameDegreeInArray2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> maxElem = new ArrayList();
        int maxFreq = 0;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
            if(map.get(nums[i]) >= maxFreq){
                maxFreq = map.get(nums[i]);
            }
        }
        for(int x : map.keySet()){
            if(map.get(x) == maxFreq){
                maxElem.add(x);
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < maxElem.size(); i++){
            int temp = maxFreq;
            int start = 0, end = 0;

            while(end < nums.length && temp > 0){
                if(nums[end] == maxElem.get(i))
                    temp--;
                end++;
            }

            while(start < end){
                if(nums[start] == maxElem.get(i))
                    break;
                start++;
            }

            ans = Math.min(ans, (end - start));
        }

        return ans;
    }
    private static int getMinimumSubArrayLengthOfSameDegreeInArray(int[] nums) {
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            leftMap.putIfAbsent(nums[i], i);
            rightMap.put(nums[i], i);

            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        int degree = Collections.max(countMap.values());
        int ans = Integer.MAX_VALUE;

        for(int x : countMap.keySet()){
            if(countMap.get(x) == degree){
                ans = Math.min(ans, (rightMap.get(x) - leftMap.get(x) + 1));
            }
        }

        return ans;
    }
}
