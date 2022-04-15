package ArraysAndStrings;


import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args){
        String[] words = {"bella","label","roller"};
        List<String> result = getCommonCharacters2(words);
        System.out.println(result);;
    }

    private static List<String> getCommonCharacters(String[] words) {
        List<HashMap<Character, Integer>> mapList = new ArrayList<>();

        for(String word : words){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            mapList.add(map);
        }
        List<String> result = new ArrayList<>();

        for(Map.Entry<Character, Integer> e : mapList.get(0).entrySet()){
            char ch = e.getKey();
            int freq = e.getValue();

            for(int i = 1; i < mapList.size(); i++){
                freq = Math.min(freq, mapList.get(i).getOrDefault(ch, 0));
            }
            for(int i = 0; i < freq; i++){
                result.add(ch + "");
            }
        }
        return result;
    }

    private static List<String> getCommonCharacters2(String[] words) {
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for(int i = 0; i < words.length; i++){
            int[] count = new int[26];
            for(char ch : words[i].toCharArray()){
                count[ch - 'a']++;
            }

            for(int j = 0; j < 26; j++){
                freq[j] = Math.min(freq[j], count[j]);
            }
        }
        List<String> result = new ArrayList<>();

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                while (freq[i] > 0)
                {
                    char ch = (char) (i + 'a');
                    result.add(ch + "");
                    freq[i]--;
                }
            }

        }
        return result;
    }
}
