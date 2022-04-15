package ArraysAndStrings;

public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args){
        int[][] grid = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        int result = getNegativesCount(grid);
        System.out.println(result);
    }

    private static int getNegativesCount(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] < 0)
                {
                    count += (row - i) * (col - j);
                    col -= col - j;
                    break;
                }
            }
        }

        return count;
    }
}
