package DP;

//https://leetcode.com/problems/decode-ways-ii/
public class DecodeWays2 {
    public static void main(String[] args){
        String s = "1*2*3";
        int waysToDecode = getDecodingWays(s);
        System.out.println(waysToDecode);
    }

    private static int getDecodingWays(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();

        return nWays_Recursive(0, s);
    }

    private static int nWays_Recursive(int i, String s) {
        if(i >= s.length())
            return 0;
        if(s.charAt(i) == '0')
            return 0;
//        if(s.charAt(i) == '*')
//            return 9;
        if(i == s.length()-1)
            return 1;

        if(s.charAt(i) == 1 || s.charAt(i) == '2' && (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6')){
            return nWays_Recursive(i+1, s) + nWays_Recursive(i+2, s);
        }
        if(s.charAt(i) == '*' || s.charAt(i) == '2' && s.charAt(i+1) == '*'){
            return (9 * nWays_Recursive(i+1, s)) + nWays_Recursive(i+2, s);
        }
        return 1;
    }
}
