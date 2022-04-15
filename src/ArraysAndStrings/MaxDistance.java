package ArraysAndStrings;

//https://www.interviewbit.com/problems/max-distance/
public class MaxDistance {
    public static void main(String[] args){
        int[] nums = {2,5,4,2};
        int result = getMaxDistance(nums);
        System.out.println(result);
    }

    private static int getMaxDistance(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMin[0] = nums[0];
        rightMax[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            leftMin[i] = Math.min(nums[i], leftMin[i-1]);
        }
        for(int i = nums.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(nums[i], rightMax[i+1]);
        }

        int i = 0, j = 0, ans = 0;
        while (i < nums.length && j < nums.length){
            if(rightMax[j] >= leftMin[i]){
                ans = Math.max(ans, j - i);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}
