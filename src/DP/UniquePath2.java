package DP;

public class UniquePath2 {
    public static void main(String[] args){
        int[][] obstacleGrid = {{1,0}};
        int possibleUniquePaths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(possibleUniquePaths);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] lookup = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    lookup[i][j] = 0;
                else if(i == 0 && j == 0)
                    lookup[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0){
                        up = lookup[i-1][j];
                    }
                    if(j > 0){
                        left = lookup[i][j-1];
                    }
                    lookup[i][j] = up + left;
                }
            }
        }

        return lookup[m-1][n-1];
    }
}
