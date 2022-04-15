package ArraysAndStrings;

public class ArrayPerfectOrNot {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,2,1};
        boolean result = checkPerfectness(nums);
        if(result)
            System.out.println("Array is PERFECT");
        else
            System.out.println("Array is NOT PERFECT");
    }
    public static boolean checkPerfectness(int[] nums){
        int i = 0, j = nums.length-1;
        while(i < j){
            if(nums[i] != nums[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
