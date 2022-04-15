package ArraysAndStrings;

public class MoveZeroes {
    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
    private static void moveZeros(int[] nums){
        int i = 0, j = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                i++;
                continue;
            }
            swap(nums, i, j);
            i++;
            j++;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
