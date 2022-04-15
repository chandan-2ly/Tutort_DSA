package ArraysAndStrings;

public class MaxConsecutiveOnes_II {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,0,0};
        int k = 0;
        int result = getMaxConsecutiveOnes(nums, k);
        System.out.println(result);
    }

    private static int getMaxConsecutiveOnes(int[] nums, int k) {
        int max = 0;
        int start = 0, end = 0;
        int zeroCount = 0;

        while(end < nums.length){
            if(nums[end] == 0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
                zeroCount--;
            }
            else {
                max = Math.max(max, (end - start + 1));
                end++;
            }
        }
        return max;
    }
}
