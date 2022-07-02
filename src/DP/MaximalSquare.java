package DP;

//https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public static void main(String[] args){
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int maxSquare = getMaximalSquare2(matrix);
        System.out.println(maxSquare);
    }

    //using DP, tabulation
    private static int getMaximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] lookup = new int[m+1][n+1];

        int max = 0;

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '0')
                    lookup[i][j] = 0;
                else{
                    lookup[i][j] = 1 + Math.min(lookup[i-1][j], Math.min(lookup[i][j-1], lookup[i-1][j-1]));
                    max = Math.max(max, lookup[i][j]);
                }

            }
        }
        return max * max;
    }

    //using recursion
    private static int getMaximalSquare2(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int temp = findSquare(matrix, i, j);
                max = Math.max(max, temp);

            }
        }
        return max * max;
    }

    // using recursion
    private static int findSquare(char[][] matrix, int i, int j) {
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0'){
            return 0;
        }
        int sum = 1 + Math.min(findSquare(matrix, i, j+1),
                Math.min(findSquare(matrix, i+1, j), findSquare(matrix, i+1, j+1)));
        return sum;
    }

    //using memoization
    private static int getMaximalSquare3(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] lookup = new int[m][n];

        int max = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int temp = findSquare2(matrix, i, j, lookup);
                max = Math.max(max, temp);

            }
        }
        return max * max;
    }

    //using memoization
    private static int findSquare2(char[][] matrix, int i, int j, int[][] lookup) {
        if(i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] == '0'){
            return lookup[i][j] = 0;
        }
        if(lookup[i][j] != 0){
            return lookup[i][j];
        }
        int sum = 1 + Math.min(findSquare2(matrix, i, j+1, lookup),
                Math.min(findSquare2(matrix, i+1, j, lookup), findSquare2(matrix, i+1, j+1, lookup)));
        return lookup[i][j] = sum;
    }
}
