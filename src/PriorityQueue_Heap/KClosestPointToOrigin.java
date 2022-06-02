package PriorityQueue_Heap;

import java.util.*;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPointToOrigin {
    public static void main(String[] args){
        int[][] points = {{0,1}, {1,0}};
        int k = 2;

        int[][] result = getKClosest(points, k);
        for (int[] arr : result)
            System.out.println(Arrays.toString(arr));
    }

    private static int[][] getKClosest(int[][] points, int k) {
//        PriorityQueue<double[]> heap = new PriorityQueue<>((a,b) -> Double.compare(a[0], b[0]));
        PriorityQueue<double[]> heap = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        for(int[] arr : points){
            double distance = getDistance(arr);
            heap.add(new double[]{distance, arr[0], arr[1]});
        }
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(new int[]{(int) heap.peek()[1], (int) heap.peek()[2]});
            heap.poll();
        }
        return result.toArray(new int[result.size()][]);
    }

    private static double getDistance(int[] arr) {
        double result = Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
        return result;
    }
}
