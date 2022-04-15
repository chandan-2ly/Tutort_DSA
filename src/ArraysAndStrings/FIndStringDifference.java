package ArraysAndStrings;
import java.util.HashMap;

public class FIndStringDifference {
    public static void main(String[] args){
        String s = "abcd";
        String t = "bcdea";
        char ch = findTheDifference(s, t);
        System.out.println("The extra character is "+ch);
    }
    private static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char extraChar = ' ';

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
            else{
                extraChar = ch;
                break;
            }

        }
        return extraChar;
    }
}
