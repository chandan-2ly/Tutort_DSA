package ArraysAndStrings;

//https://leetcode.com/problems/search-a-2d-matrix/submissions/
public class SearchIn2DMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean result = isTargetExist(matrix, target);
        System.out.println(result);
         
    }

    private static boolean isTargetExist(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowToSearch = -1;

        if(matrix[0][0] > target) return false;
        if(matrix[0][0] == target) return true;
        if(matrix[0][n-1] == target) return true;
        if(matrix[0][n-1] > target) rowToSearch = 0;

        if(rowToSearch < 0){
            for(int i = 1; i < matrix.length; i++){
                if(matrix[i][0] == target) return true;
                if(matrix[i][0] > target) break;
                if(matrix[i][n-1] == target) return true;
                if(matrix[i][n-1] < target) continue;
                if(matrix[i][n-1] > target) {
                    rowToSearch = i;
                    break;
                }
            }
        }

        if(rowToSearch >= 0){
            return binarySearch(matrix[rowToSearch], target);
        }

        return false;

    }
    private static boolean binarySearch(int[] arr, int key){
        int high = arr.length - 1;
        int low = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key) return true;

            if(key > arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}
