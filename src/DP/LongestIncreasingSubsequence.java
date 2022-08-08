package DP;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = getLengthOfLis(nums);
        System.out.println(result);
    }

    private static int getLengthOfLis(int[] nums) {
        return getLength(nums, 0,0);
    }

    private static int getLength(int[] nums, int i, int j) {
        if(i >= nums.length || j >= nums.length)
            return 0;
        //if()
        return 5;

    }
}
