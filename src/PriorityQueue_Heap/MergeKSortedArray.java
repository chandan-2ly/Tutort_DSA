package PriorityQueue_Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static void main(String[] args){
        int k = 3;
        int n = 5;

        int[][] num = {{1,5,6,9,11},{2,3,7,8,10}, {4,12,13,14,15}};

        List<Integer> result = mergeSortedList(num, k, n);
        System.out.println(result);
    }

    private static List<Integer> mergeSortedList(int[][] num, int k, int n) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int row = 0; row < k; row++){
            heap.add(new int[]{row, 0, num[row][0]});
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < k * (n-1); j++){
            int[] temp = heap.poll();
            result.add(temp[2]);
            int l = temp[1] + 1;
            if(l < n)
                heap.add(new int[]{temp[0], l, num[temp[0]][l]});
        }
        return result;
    }
}
