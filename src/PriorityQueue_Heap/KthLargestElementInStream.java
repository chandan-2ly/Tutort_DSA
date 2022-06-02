package PriorityQueue_Heap;

import java.util.Arrays;

public class KthLargestElementInStream {
    public static void main(String[] args){
        KthLargest obj = new KthLargest(3, new int[]{});
        int[] numsToAdd = {-1,1,-2,-4,3};
        int[] result = new int[numsToAdd.length];
        for (int i = 0; i < numsToAdd.length; i++){
            result[i] = obj.add(numsToAdd[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
