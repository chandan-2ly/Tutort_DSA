package PriorityQueue_Heap;

import java.util.Arrays;

public class BuildHeap {
    public static void main(String[] args){
        int[] nums = {4,3,1,5,6,7,9};
        Heap h = buildHeap2(nums);

        System.out.println(Arrays.toString(h.arr));
    }
    //App - 1, using sorting
    private static Heap buildHeap(int[] nums) {
        Arrays.sort(nums);

        Heap h = new Heap(nums.length, 1);
        for(int i = nums.length - 1; i >= 0; i--){
            Heap.insert(h, nums[i]);
        }

        return h;
    }

    //App - 2, using insert and perculate up
    private static Heap buildHeap2(int[] nums){
        Heap h = new Heap(nums.length, 1);

        for (int i = 0; i < nums.length; i++){
            h.arr[i] = nums[i];
            h.count++;
            Heap.perculateUp(h, i);
        }
        return h;
    }

    //App-3, using perculate down
    private static Heap buildHeap3(int[] nums){
        Heap h = new Heap(nums.length, 1);
        for(int i = 0; i < nums.length; i++){
            h.arr[i] = nums[i];
            h.count++;
        }

        int lastLeaf = h.count - 1;
        int lastNonLeaf = (lastLeaf - 1)/2;    //last non leaf node is parent of last leaf node

        while (lastNonLeaf >= 0){
            Heap.perculateDown(h, lastNonLeaf);
            lastNonLeaf--;
        }
        return h;
    }
}
