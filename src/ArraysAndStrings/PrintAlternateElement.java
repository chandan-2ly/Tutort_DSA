package ArraysAndStrings;

public class PrintAlternateElement {
    public static void main(String[] args){
        int N = 4;
        int[] nums = {1,2,3,4};

        printElement(N, nums);
    }

    public static void printElement(int N, int[] nums){
        for(int i = 0; i < N; i = i+2){
            System.out.println(nums[i]);
        }
    }
}
