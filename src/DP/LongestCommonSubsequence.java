package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";
//        int result = longestCommonSubsequence(text1, text2);
        int result = longestCommonSubsequence_DP(text1, text2);
        System.out.println(result);
    }

    private static int longestCommonSubsequence_DP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] lookup = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            lookup[i][0] = 0;
        }
        for(int i = 0; i <= n; i++){
            lookup[0][i] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    lookup[i][j] = 1 + lookup[i-1][j-1];
                }
                else {
                    lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
                }
            }
        }

        return lookup[m][n];
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //return getLongestSubsequence_recursive(text1, m-1, text2, n-1);
        int[][] lookup = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(lookup[i], -1);

        getLongestSubsequence_Memoization(text1, m-1, text2, n-1, lookup);
        return lookup[m-1][n-1];
    }

    private static int getLongestSubsequence_recursive(String text1, int i, String text2, int j) {
        if(i < 0 || j < 0)
            return 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + getLongestSubsequence_recursive(text1, i-1, text2, j-1);
        }
        return Math.max(getLongestSubsequence_recursive(text1, i-1, text2, j),
                getLongestSubsequence_recursive(text1, i, text2, j-1));
    }
    private static int getLongestSubsequence_Memoization(String text1, int i, String text2, int j,
                                                         int[][] lookup) {
        if(i < 0 || j < 0)
            return 0;
        if(lookup[i][j] != -1)
            return lookup[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            lookup[i][j] = 1 + getLongestSubsequence_Memoization(text1, i-1, text2, j-1, lookup);
            return lookup[i][j];
        }
        lookup[i][j] = Math.max(getLongestSubsequence_Memoization(text1, i-1, text2, j,lookup),
                getLongestSubsequence_Memoization(text1, i, text2, j-1, lookup));
        return lookup[i][j];
    }

}
