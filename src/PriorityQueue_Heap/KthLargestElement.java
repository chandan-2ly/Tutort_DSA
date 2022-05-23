package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,3};
        int k = 4;
        int result = getKthLargestElem2(nums, k);
        System.out.println(result);
    }

    private static int getKthLargestElem(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        for(int i = 0; i < k - 1; i++){
            if(queue.isEmpty())
                return -1;
            queue.poll();
        }
        if(queue.size() > 0)
            return queue.poll();
        return -1;
    }
    private static int getKthLargestElem2(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(queue.size() > 0 && nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        if(queue.size() > 0)
            return queue.peek();
        return -1;
    }
}
