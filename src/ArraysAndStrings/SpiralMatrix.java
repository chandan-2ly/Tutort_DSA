package ArraysAndStrings;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{335, 401, 128, 384, 345, 275, 324, 139, 127, 343, 197, 177, 127, 72, 13, 59},
                {102, 75, 151, 22, 291, 249, 380, 151, 85, 217, 246, 241, 204, 197, 227, 96},
                {261, 163, 109, 372, 238, 98, 273, 20, 233, 138, 40, 246, 163, 191, 109, 237},
                {179, 213, 214, 9, 309, 210, 319, 68, 400, 198, 323, 135, 14, 141, 15, 168}};
        int[] result = getSpiralOrderElements(matrix);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getSpiralOrderElements(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[] result = new int[m*n];
        int top = 0, down = m - 1, right = n - 1, left = 0;
        int direction = 0;
        int k = 0;

        while(top <= down && left <= right){
            if(direction == 0){         //left to right
                for(int i = left; i <= right; i++){
                    result[k++] = A[top][i];
                }
                top++;
            }
            else if(direction == 1){        //down
                for(int i = top; i <= down; i++){
                    result[k++] = A[i][right];
                }
                right--;
            }
            else if(direction == 2){        // right to left
                for(int i = right; i >= left; i--){
                    result[k++] = A[down][i];
                }
                down--;
            }
            else if(direction == 3){
                for(int i = down; i >= top; i--){
                    result[k++] = A[i][left];
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}
