package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3,3,3,3};
        int k = 2;
        int[] result = getKFrequentElements(nums, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getKFrequentElements(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            heap.add(m.getKey());
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }

}
