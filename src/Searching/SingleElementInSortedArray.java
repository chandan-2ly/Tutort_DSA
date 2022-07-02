package Searching;

//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {
    public static void main(String[] args){
        int nums[] = {1,1};
        int singleElement = getSingleElement(nums);
        System.out.println(singleElement);
    }

    private static int getSingleElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int elem = binarySearch(nums, 0, nums.length-1);
        return elem;
    }

    private static int binarySearch(int[] nums, int low, int high) {
        int result = -1;
        if(low > high || low == -1 || high == -1)
            return -1;
        int mid = low + (high - low)/2;
        if(mid == 0 && nums[mid] < nums[mid+1])
            return nums[mid];
        else if(mid == 0) return -1;

        if(mid == high && nums[mid] > nums[mid-1])
            return nums[mid];
        else if(mid == high) return -1;

        if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
            return nums[mid];
        }
        if(nums[mid] == nums[mid-1]){
            result = binarySearch(nums, low, mid-2);
            if(result == -1){
                result = binarySearch(nums, mid+1, high);
            }
        }
        else if(nums[mid] == nums[mid+1]){
            result = binarySearch(nums, low, mid-1);
            if(result == -1){
                result = binarySearch(nums, mid+2, high);
            }
        }
        return result;
    }
}
