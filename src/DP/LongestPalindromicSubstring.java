package DP;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        String s = "cccc";
        String result = getLongestPalindromicSubstring_DP(s);
        System.out.println(result);
    }

    //TODO
    private static String getLongestPalindromicSubstring(String s) {
        String[] longestSubstring = new String[1];
        longestSubstring[0] = "";
        isPalindrome(0, s.length()-1, s, longestSubstring);
        return longestSubstring[0];
    }

    private static boolean isPalindrome(int start, int end, String s, String[] longestSubstring) {
        if(start > end)
            return true;
        if(start == end) {
            if((end-start+1) > longestSubstring[0].length())
                longestSubstring[0] = s.substring(start, end+1);
            return true;
        }
        if(s.charAt(start) != s.charAt(end))
            return false;

        if(s.charAt(start) == s.charAt(end) && isPalindrome(start + 1, end - 1, s, longestSubstring)){
            if((end-start+1) > longestSubstring[0].length())
                longestSubstring[0] = s.substring(start, end+1);
            return true;
        }
        if (isPalindrome(start + 1, end, s, longestSubstring)){
            if((end-start+1) > longestSubstring[0].length())
                longestSubstring[0] = s.substring(start, end+1);
        }
        if (isPalindrome(start, end-1, s, longestSubstring)){
            if((end-start+1) > longestSubstring[0].length())
                longestSubstring[0] = s.substring(start, end+1);
        }
        return false;
    }

    private static String getLongestPalindromicSubstring_DP(String s){
        if(s == null || s.length() <= 1)
            return s;
        boolean[][] lookup = new boolean[s.length()][s.length()];
        String res = "";

        for(int i = 0; i < s.length(); i++){
            lookup[i][i] = true;
            if(i == 0)
                res = s.substring(i, i+1);
        }
        for (int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                if (res.length() < 2) {
                    res = s.substring(i, i + 2);
                }
                lookup[i][i+1] = true;
            }
            else lookup[i][i+1] = false;
        }

        for(int k = 2; k < s.length(); k++){
            int i = 0;
            int j = k;

            while (i < s.length() && j < s.length()){
                if(s.charAt(i) == s.charAt(j) && lookup[i + 1][j - 1]){
                    if((j-i+1) > res.length()){
                        res = s.substring(i, j+1);
                    }
                    lookup[i][j] = true;
                }
                i++;
                j++;
            }
        }
        return res;


    }
}
