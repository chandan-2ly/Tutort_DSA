package ArraysAndStrings;

public class RangeSum2D {
    public static void main(String[] args){
        int[][] matrix =
        {
                {-4,-5}
        };

        initializeMatrix(matrix);
        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
        int sum = getSumRegion(matrix, row1, col1, row2, col2);
        System.out.println(sum);
    }

    private static int getSumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = matrix[row2][col2];

        if(row1 > 0){
            sum -= matrix[row1-1][col2];
        }
        if(col1 > 0){
            sum -= matrix[row2][col1-1];
        }
        if(row1 > 0 && col1 > 0){
            sum += matrix[row1-1][col1-1];
        }
        return sum;
    }

    private static void initializeMatrix(int[][] matrix) {
        //row wise prefix sum
        for(int i = 0; i < matrix.length; i++){
            int prefixSum = 0;
            for(int j = 0; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] += prefixSum;
                prefixSum += temp;
            }
        }

        //column wise prefix sum
        for(int i = 0; i < matrix[0].length; i++){
            int prefixSum = 0;
            for(int j = 0; j < matrix.length; j++){
                int temp = matrix[j][i];
                matrix[j][i] += prefixSum;
                prefixSum += temp;
            }
        }
    }
}
