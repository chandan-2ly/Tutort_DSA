package ArraysAndStrings;

public class findElementEqualToIndex {
    public static void main(String[] args){
        int N = 1;
        int[] nums = {1};
        int result = getElementEqualToIndex(N, nums);
        System.out.println("Result "+result);
    }

    public static int getElementEqualToIndex(int N, int[] nums){
        for(int i = 0; i < N; i++){
            if(i+1 == nums[i])
                return i+1;
        }
        return 0;
    }
}
