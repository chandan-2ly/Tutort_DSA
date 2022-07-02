package DP;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args){
        String A = "horse";
        String B = "ros";
        int m = A.length();
        int n = B.length();
        //int result = getMinimumOperationCount_recursive(A, m, B, n);
        int result2 = getMinimumOperationCount_tabulation(A, m, B, n);
        System.out.println(result2);
    }

    private static int getMinimumOperationCount_tabulation(String word1, int m, String word2, int n) {
        int[][] lookup = new int[m + 1][n + 1];

        for(int i = 0; i <= n; i++){
            lookup[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            lookup[i][0] = i;
        }

        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    lookup[i][j] = lookup[i-1][j-1];
                }
                else{
                    int insertCount = lookup[i][j-1] + 1;
                    int updateCount = lookup[i-1][j-1] + 1;
                    int deleteCount = lookup[i-1][j] + 1;

                    lookup[i][j] = Math.min(insertCount, Math.min(updateCount, deleteCount));
                }
            }
        }

        return lookup[word1.length()][word2.length()];
    }

//    private static int getMinimumOperationCount_recursive(String A, int m, String B, int n) {
//        if(m == 0)
//            return n;
//        if(n == 0)
//            return m;
//        if()
//    }
}
