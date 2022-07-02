package Searching;

public class SearchInRotatedArray2 {
    public static void main(String[] args){
        int[] nums = {1,3};
        int target = 0;
        boolean result = search(nums, target);
        System.out.println(result);
    }

    private static boolean search(int[] nums, int target) {
        if(nums[0] == target || nums[nums.length - 1] == target)
            return true;

        int low = 0;
        int high = nums.length - 1;
        int pivotIndex = getPivotIndex(nums);

        //then array is not rotated, so directly do binarySearch
        if(pivotIndex == -1){
            return binarySearch(nums, target, low, high);
        }
        if(target == nums[pivotIndex])
            return true;

        //if target is greater then search in left side
        if(target > nums[0]){
            return binarySearch(nums, target, 0, pivotIndex - 1);
        }
        return binarySearch(nums, target, pivotIndex+1, high);
    }

    private static int getPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end){
            int mid = start + (end - start)/2;

            //if mid element is greater than next element then mid is the pivot element
            if(mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            //if mid element is lesser than previous element then previous index is the pivot index
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[start] == nums[mid] && nums[end] == nums[mid]){

                //check if the start is pivot
                if(nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                //check if the end is pivot index
                if(nums[end] < nums[end-1]){
                    return end-1;
                }
                end--;
            }
            else if(nums[start] < nums[mid] ||(nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static boolean binarySearch(int[] nums, int target, int low, int high) {
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;

            if(nums[mid] == target)
                return true;
            if(target > nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static boolean search2(int[] nums, int target) {
        if(nums[0] == target || nums[nums.length - 1] == target)
            return true;

        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
                return true;

            //ignore the same elements
            if(nums[mid] == nums[low] && nums[high] == nums[mid]){
                low++;
                high--;
            }

            //left side sorted
            else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            //right side sorted
            else if(nums[mid] <= nums[high]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
