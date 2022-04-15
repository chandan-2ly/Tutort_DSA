package ArraysAndStrings;

public class IntegersSum {
    public static void main(String[] args){
        int n = 6;
        int[] nums = {5, 8, 3, 10, 22, 45};
        int sum = getSum(n, nums);
        System.out.println("sum = "+sum);
    }

    public static int getSum(int n, int[] nums){
        if(n == 0)
            return -1;
        int sum = nums[0];
        for(int i = 1; i < n; i++){
            sum += nums[i];
        }
        return sum;
    }
}

