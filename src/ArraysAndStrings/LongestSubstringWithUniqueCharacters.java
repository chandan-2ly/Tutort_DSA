package ArraysAndStrings;

import java.util.*;

public class LongestSubstringWithUniqueCharacters {
    public static void main(String[] args){
        String[] strs = {"pwwkew","aab","au","abcabcbb","bbbbb","abba"};
        List<String> result = new ArrayList<>();
        for(String str : strs){
            result.add(getLongestSubstring(str));
        }

        System.out.println(result);
    }

    private static String getLongestSubstring2(String s) {
        if(s.length() == 0 || s.length() == 1) return s;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        String result = "";

        while(start <= end && end < s.length()){
            if(map.containsKey(s.charAt(end))){
                int temp = end - start;
                if(temp > maxLength){
                    maxLength = temp;
                    result = s.substring(start, end);
                }
                int charIndex = map.get(s.charAt(end));
                if(start >= charIndex){
                    map.put(s.charAt(end), end);
                }
                start = charIndex + 1;
            }
            else{
                map.put(s.charAt(end), end);
            }
            end++;
        }
        if(maxLength < (end - start)){
             maxLength = (end - start);
             result = s.substring(start,end);
        }
        return result;

    }
    private static String getLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s;

        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        String result = "";

        while(start <= end && end < s.length()){
            if(set.contains(s.charAt(end))){
                while(set.contains(s.charAt(end))){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            else{
                int temp = end - start + 1;
                if(temp > maxLength){
                    maxLength = temp;
                    result = s.substring(start, end+1);
                }
                set.add(s.charAt(end));
                end++;
            }

        }
        return result;
    }
}
