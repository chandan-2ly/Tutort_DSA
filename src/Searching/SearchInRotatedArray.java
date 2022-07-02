package Searching;

public class SearchInRotatedArray {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        int result = search(nums, target);
        System.out.println(result);
    }

    private static int search(int[] nums, int target) {
        if(nums[0] == target) return 0;

        int pivotIndex = getPivotIndex(nums);

        int ans = -1;
        int low = 0, high = nums.length - 1;

        if(nums[pivotIndex] == target) return pivotIndex;
        else if(target > nums[0]){
            high = pivotIndex - 1;
            ans = binarySearch(nums, low, high, target);
        }
        else{
            low = pivotIndex + 1;
            ans = binarySearch(nums, low, high, target);
        }
        return ans;
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;

            if(nums[mid] == target) return mid;
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int getPivotIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low+high)/2;

            if(nums[mid] >= nums[0]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    private static int search2(int[] nums, int target) {
        if(nums[0] == target) return 0;
        if(nums[nums.length - 1] == target)
            return nums.length - 1;

        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
                return mid;

            //left side sorted
            if(nums[mid] >= nums[low]){
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

        return -1;
    }
}
