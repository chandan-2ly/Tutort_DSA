package PriorityQueue_Heap;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args){
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> result = getTopKFrequentWords(words, k);
        System.out.println(result);
    }

    private static List<String> getTopKFrequentWords(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((b,a) ->
                map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));

        for (Map.Entry<String, Integer> m : map.entrySet()){
            heap.add(m.getKey());
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(heap.poll());
        }
        return result;
    }
}
