package RecursionBacktracking;

import java.util.*;

public class Subset2 {
    public static void main(String[] args){
        int[] nums = {2,1,2,1,3};
        List<List<Integer>> result = getSubsequences2(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> getSubsequences(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        getSubsequencesUtil(nums, subset, set, index);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : set){
            result.add(list);
        }
        return result;
    }
    private static List<List<Integer>> getSubsequences2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        getSubsequencesUtil2(nums, subset, result, index);

        return result;
    }

    private static void getSubsequencesUtil(int[] arr, List<Integer> subset, HashSet<List<Integer>> set, int index) {
        if(index >= arr.length){
            List<Integer> temp = new ArrayList<>(subset);
            Collections.sort(temp);
            set.add(temp);
            return;
        }
        subset.add(arr[index]);
        getSubsequencesUtil(arr, subset, set, index + 1);
        subset.remove(new Integer(arr[index]));
        getSubsequencesUtil(arr, subset, set, index + 1);
    }
    private static void getSubsequencesUtil2(int[] nums, List<Integer> subset, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            getSubsequencesUtil2(nums, subset, result, i+1);
            subset.remove(subset.size()-1);
        }
    }
}
