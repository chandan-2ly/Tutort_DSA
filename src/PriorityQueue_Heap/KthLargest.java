package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    private int[] nums;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        this.k = k;
        if (nums.length > 0) {
            if (k > nums.length) {
                for (int num : nums) {
                    queue.add(num);
                }
            } else {
                for (int i = 0; i < k; i++) {
                    queue.add(nums[i]);
                }
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (queue.size() > 0 && nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
    }
    public int add(int val) {
        if(queue.size() == 0)
            queue.add(val);
        else if(queue.size() < k)
            queue.add(val);

        else if(queue.size() == k && val > queue.peek()){
            queue.poll();
            queue.add(val);
        }
        if(queue.size() > 0)
            return queue.peek();
        return -1;
    }
}
