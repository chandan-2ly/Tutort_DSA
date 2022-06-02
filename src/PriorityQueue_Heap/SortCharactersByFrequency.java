package PriorityQueue_Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sort-characters-by-frequency/submissions/
public class SortCharactersByFrequency {
    public static void main(String[] args){
        String s = "tree";
        String result = sortCharactersByFreq(s);
        System.out.println(result);
    }

    private static String sortCharactersByFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (Map.Entry<Character, Integer> m : map.entrySet()){
            heap.add(m.getKey());
        }

        StringBuilder result = new StringBuilder();
        while (heap.size() > 0){
            char ch = heap.poll();
            for (int i = 0; i < map.get(ch); i++)
                result.append(ch);
        }
        return result.toString();
    }
}
