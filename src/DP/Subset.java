package DP;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = getSubset_recursive(nums);
        for(List<Integer> set : subsets){
            System.out.println(set);;
        }
    }

    private static List<List<Integer>> getSubset_recursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer> temp = new ArrayList<>();

        getSet(0, nums, result, temp);

        return result;
    }

    private static void getSet(int i, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if(i >= nums.length) {
            if (temp.size() > 0)
                result.add(new ArrayList<>(temp));
            return;
        }
        //pick
        temp.add(nums[i]);
        getSet(i+1, nums, result, temp);

        //don't pick
        temp.remove(temp.size()-1);
        getSet(i+1, nums, result, temp);
    }

//    private static List<List<Integer>> getSubset_DP(int[] nums) {
//        //todo
//    }
}
