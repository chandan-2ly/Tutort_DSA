package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesWhoseSumIsK {
    public static void main(String[] args){
        int k = 5;
        int[] arr = {1,2,3,4,5};
        List<List<Integer>> result = getSubsequencesWithSumK(arr, k);
        System.out.println(result);
    }

    private static List<List<Integer>> getSubsequencesWithSumK(int[] arr, int k) {
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        getSubsequencesWithSumKUtil(arr, k, sum, result, subset, index);
        return result;
    }

    private static void getSubsequencesWithSumKUtil(int[] arr, int k, int sum, List<List<Integer>> result,
                                                    List<Integer> subset, int index) {
        if(index >= arr.length){
            if(sum == k)
                result.add(new ArrayList<>(subset));
            return;
        }
        sum += arr[index];
        subset.add(arr[index]);
        getSubsequencesWithSumKUtil(arr, k, sum, result, subset, index+1);
        sum -= arr[index];
        subset.remove(new Integer(arr[index]));
        getSubsequencesWithSumKUtil(arr, k, sum, result, subset, index+1);
    }
}
