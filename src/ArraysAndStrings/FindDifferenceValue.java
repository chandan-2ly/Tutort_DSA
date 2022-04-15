package ArraysAndStrings;

public class FindDifferenceValue {
    public static void main(String[] args){
        int N = 5;
        int[] nums = { 1, 2, 1, 2, 1};
        int result = getDifferenceValue(N, nums);
        System.out.println("Result "+result);
    }
    public static int getDifferenceValue(int N, int[] nums){
        int i = 0, j = N/2;
        int leftSum = 0;
        int rightSum = 0;
        while(i < N/2 && j < N){
            leftSum += nums[i];
            rightSum += nums[j];
            i++;
            j++;
        }
        while (j < N){
            rightSum += nums[j];
            j++;
        }
        return Math.abs(leftSum-rightSum);
    }
}
