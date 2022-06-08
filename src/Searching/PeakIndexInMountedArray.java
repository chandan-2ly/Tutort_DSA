package Searching;

public class PeakIndexInMountedArray {
    public static void main(String[] args){
        int[] arr = {3,5,3,2,0};
        System.out.println(getPeakInArray(arr));
    }

    private static int getPeakInArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high){
            int mid = low + (high-low)/2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n -1 || arr[mid] > arr[mid + 1]))
                return mid;
            if((mid == n-1 || arr[mid] < arr[mid + 1]) && (mid == 0 || arr[mid] > arr[mid - 1])){
                low = mid + 1;
            }
            else if((mid == 0 || arr[mid] < arr[mid - 1]) && (mid == n-1 || arr[mid] > arr[mid + 1])) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
