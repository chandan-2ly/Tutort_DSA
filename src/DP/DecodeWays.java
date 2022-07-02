package DP;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public static void main(String[] args){
        String s = "06";
        int ans = getWaysToDecode_DP(s);
        System.out.println(ans);
    }

    private static int getWaysToDecode(String s) {

        return nWays(0, s);
    }
    //recursion with memoization
    private static int getWaysToDecode3(String s) {

        int[] lookup = new int[s.length()+1];
        return nWays3(0, s, lookup);
    }

    private static int nWays3(int i, String s, int[] lookup) {
        if(i >= s.length())
            return 1;
        if(s.charAt(i) == '0')
            return 0;
        if(i == s.length()-1)
            return 1;
        if(lookup[i] != 0)
            return lookup[i];

        //if the first character is 1 then obviously the next character will come  in 0-9, but if the
        //character is 2 then we have to check whether the number is lesser than equal to 26 i.e. second character
        //should come in between 0-6 only
        if(s.charAt(i) =='1' || (s.charAt(i) == '2' && (s.charAt(i+1) >= 48 && s.charAt(i+1) <=54))){
            lookup[i] =  nWays3(i+1, s, lookup) + nWays3(i+2, s, lookup);
            return lookup[i];
        }
        lookup[i] = nWays3(i+1, s, lookup);
        return lookup[i];
    }

    private static int getWaysToDecode2(String s) {

        if(s.length() == 0){
            return 1;
        }
        if(s.length() == 2 && Integer.parseInt(s) > 26)
            return 1;

        if(s.charAt(0) == '0'){
            return 0;
        }

        int sum = getWaysToDecode2(s.substring(1));
        if(s.length() > 1) {
            sum += getWaysToDecode2(s.substring(2));
        }
        return sum;
    }

    private static int nWays(int i, String s) {
        if(i >= s.length())
            return 1;
        if(s.charAt(i) == '0')
            return 0;
        if(i == s.length()-1)
            return 1;

        //if the first character is 1 then obviously the next character will come  in 0-9, but if the
        //character is 2 then we have to check whether the number is lesser than equal to 26 i.e. second character
        //should come in between 0-6 only
        if(s.charAt(i) =='1' || (s.charAt(i) == '2' && (s.charAt(i+1) >= 48 && s.charAt(i+1) <=54))){
            return nWays(i+1, s) + nWays(i+2, s);
        }
        return nWays(i+1, s);
    }

    private static int getWaysToDecode_DP(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;

        int[] lookup = new int[s.length()+1];
        lookup[0] = 1;
        if(s.charAt(0) == '*')
            lookup[1] = 9;
        else
            lookup[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9'){
                lookup[i] = lookup[i-1];
            }
            else if(s.charAt(i-1) == '*'){
                lookup[i] = 9 * lookup[i-1];
            }
            if(s.charAt(i-2) == '1'){
                lookup[i] += lookup[i-2];
            }
            else if(s.charAt(i-2) == '2' && (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6')){
                lookup[i] += lookup[i-2];
            }
        }
        return lookup[s.length()];
    }
}
