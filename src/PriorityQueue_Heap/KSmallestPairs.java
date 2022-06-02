package PriorityQueue_Heap;

import java.util.*;

public class KSmallestPairs {
    public static void main(String[] args){
//        int[] nums1 = {1,7,11};
//        int[] nums2 = {2,4,6};
//        int k = 3;
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 2;
//        int[] nums1 = {1,2};
//        int[] nums2 = {3};
//        int k = 3;

        List<List<Integer>> result = getKSmallestPairs(nums1, nums2, k);
        for(List<Integer> pair : result)
            System.out.println(pair);
    }

    private static List<List<Integer>> getKSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>(
                (a,b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));
        int i = 0, j = 0;
        int max = 0;
        while (i < nums1.length) {
            j = 0;
            while (j < nums2.length) {
                maxHeap.add(Arrays.asList(nums1[i], nums2[j]));
                max = nums1[i] + nums2[j];
                j++;
                if(maxHeap.size() == k)
                    break;
            }
            if(j == nums2.length){
                i++;
                j = 0;
            }
            if(maxHeap.size() == k)
                break;
        }

        while (i < nums1.length){
            if(nums1[i] > max)
                break;
            boolean isSmall = true;
            while (j < nums2.length){
                int sum = nums1[i] + nums2[j];
                int heapElemSum = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                if(sum <= heapElemSum){
                    maxHeap.poll();
                    maxHeap.add(Arrays.asList(nums1[i], nums2[j]));
                }
                else{
                    isSmall = false;
                    break;
                }
                j++;
            }
            j = 0;
            i++;
        }

        List<List<Integer>> result = new ArrayList<>();
        while (maxHeap.size() > 0){
            result.add(maxHeap.poll());
        }

        return result;
    }
}
