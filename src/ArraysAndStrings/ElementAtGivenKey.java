package ArraysAndStrings;

public class ElementAtGivenKey {
    public static void main(String[] args){
        int index = 4;
        int[] nums = {10, 20, 30, 40, 50, 60, 70};
        int result = getElementAtIndex(index, nums, nums.length);
        System.out.println("Element is "+result);
    }

    public static int getElementAtIndex(int index, int[] nums, int length){
        if(index >= length || index < 0)
            return -1;
        return nums[index];
    }
}
