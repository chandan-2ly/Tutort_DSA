package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPairDistance {
    public static void main(String[] args){
        int[] nums = {1,3,1};
        int k = 1;
        int result = getKthSmallestPairDistance2(nums, k);
        System.out.println(result);
    }

    private static int getKthSmallestPairDistance(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j < nums.length; j++){
                int diff = Math.abs(nums[i] - nums[j]);
                heap.add(diff);
                if(heap.size() > k)
                    heap.poll();
            }
        }
        return heap.peek();
    }
    private static int getKthSmallestPairDistance2(int[] nums, int k) {
        Arrays.sort(nums);
        int low = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if(diff < low)
                low = diff;
        }
        int high = nums[nums.length - 1] - nums[0];
        while (low < high){
            int mid = low + (high-low)/2;
            int count = getSmallerPairsCount(nums, mid);
            if(count < k)
                low = mid+1;
            else high = mid;
        }
        return low;
    }

    private static int getSmallerPairsCount(int[] nums, int mid) {
        int i = 0;
        int count = 0;
        for (int j = 1; j < nums.length; j++){
            int diff = nums[j] - nums[i];
            while (diff > mid){
                i++;
                diff = nums[j] - nums[i];
            }
            count += j-i;
        }
        return count;
    }
}
