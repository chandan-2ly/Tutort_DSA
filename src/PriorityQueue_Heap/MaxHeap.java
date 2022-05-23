package PriorityQueue_Heap;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args){
        Heap h1 = new Heap(7, 1);
        Heap h2 = new Heap(3, 1);
        int[] nums1 = {10,5,6,2};

        for(int i = 0; i < nums1.length; i++){
            Heap.insert(h1, nums1[i]);
        }

        int[] nums2 = {12, 7, 9};
        for(int i = 0; i < nums2.length; i++){
            Heap.insert(h2, nums2[i]);
        }

        mergeTwoHeaps(h1, h2);
        System.out.println(Arrays.toString(h1.arr));
    }

    private static void mergeTwoHeaps(Heap h1, Heap h2) {
        for(int i = 0; i < h2.count; i++){
            h1.arr[h1.count] = h2.arr[i];
            h1.count++;
        }
        int lastLeaf = h1.count - 1;
        int lastNonLeaf = (lastLeaf - 1)/2;    //last non leaf node is parent of last leaf node

        while (lastNonLeaf >= 0){
            Heap.perculateDown(h1, lastNonLeaf);
            lastNonLeaf--;
        }
    }
}
