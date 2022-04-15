package ArraysAndStrings;

import java.util.HashMap;

public class FascinatingNumber {
    public static void main(String[] args){
        long N = 192;
        boolean result = isFascinating(N);
        if(result){
            System.out.println("Fascinating");
        }
        else System.out.println("Not Fascinating");
    }
    public static boolean isFascinating(Long N){
        HashMap<Character, Integer> map = new HashMap<>();

        long secondMultiple = N*2;
        long thirdMultiple = N*3;
        String s = Long.toString(N) + Long.toString(secondMultiple) + Long.toString(thirdMultiple);
        if(s.length() != 9)
            return false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                return false;
            map.put(ch, 1);
        }
        return true;
    }
}
