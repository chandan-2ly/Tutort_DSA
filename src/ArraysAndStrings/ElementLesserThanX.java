package ArraysAndStrings;

public class ElementLesserThanX {
    public static void main(String[] args){
        int N = 12;
        int[] nums = {1,2,2,2,2,2,2,2,3,4,5,6};
        int X = 4;
        int count = getLesserCount(N, nums, X);
        System.out.println("Result "+count);
    }

    public static int getLesserCount(int N, int[] nums, int X){
        int count = 0;
//        for(int i = N-1; i >= 0; i--){
//            if(nums[i] <= X){
//                count = i+1;
//                break;
//            }
//        }
        int low = 0, high = N-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] <= X){
                count = mid + 1;
                low = mid + 1;
            }
            else if(nums[mid] > X){
                high = mid - 1;
            }
        }
        return count;
    }
}
