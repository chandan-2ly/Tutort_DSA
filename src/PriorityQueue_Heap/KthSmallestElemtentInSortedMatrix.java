package PriorityQueue_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElemtentInSortedMatrix {
    public static void main(String[] args){
//        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
//        int k = 5;
        int[][] matrix = {{1,2,3}, {1,3,4}, {1,4,5}};
        int k = 4;
//        int[][] matrix = {{-5}};
//        int k = 1;
//        int[][] matrix = {{1,2}, {1,3}};
//        int k = 2;
        int result = getKthSmallest(matrix, k);
        System.out.println(result);
    }

    private static int getKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, j = 0;
        while (i < matrix.length) {
            while (j < matrix[i].length) {
                heap.add(matrix[i][j]);
                j++;
                if(heap.size() == k)
                    break;
            }
            if(j == matrix[i].length){
                i++;
                j = 0;
            }
            if(heap.size() == k)
                break;
        }

        while(i < matrix.length){
            while (j < matrix[i].length){
                if(heap.size() > 0 && matrix[i][j] < heap.peek()){
                    heap.poll();
                    heap.add(matrix[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
        }

        return heap.peek();
    }
}
