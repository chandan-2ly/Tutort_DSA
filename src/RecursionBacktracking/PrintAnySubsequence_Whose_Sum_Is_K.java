package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAnySubsequence_Whose_Sum_Is_K {
    public static void main(String[] args){
        int k = 4;
        int[] arr = {1,2,3};
        List<Integer> result = getSubsequenceWithSumK(arr, k);
        System.out.println(result);
    }

    private static List<Integer> getSubsequenceWithSumK(int[] arr, int k) {
        int sum = 0;
        List<Integer> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        getSubsequenceWithSumKUtil(arr, k, sum, result, subset, index);
        return result;
    }

    private static void getSubsequenceWithSumKUtil(int[] arr, int k, int sum, List<Integer> result, List<Integer> subset, int index) {
        if(result.size() > 0) return;
        if(index >= arr.length){
            if(sum == k)
                result.addAll(new ArrayList<>(subset));
            return;
        }
        sum += arr[index];
        subset.add(arr[index]);
        getSubsequenceWithSumKUtil(arr, k, sum, result, subset, index+1);
        sum -= arr[index];
        subset.remove(new Integer(arr[index]));
        getSubsequenceWithSumKUtil(arr, k, sum, result, subset, index+1);
    }
}
