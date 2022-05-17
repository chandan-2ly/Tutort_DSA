package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        List<List<Integer>> result = getSubsequences(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> getSubsequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        getSubsequencesUtil(arr, subset, result, index);
        return result;
    }

    private static void getSubsequencesUtil(int[] arr, List<Integer> subset, List<List<Integer>> result, int index) {
        if(index >= arr.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[index]);
        getSubsequencesUtil(arr, subset, result, index + 1);
        subset.remove(new Integer(arr[index]));
        getSubsequencesUtil(arr, subset, result, index + 1);
    }
}
