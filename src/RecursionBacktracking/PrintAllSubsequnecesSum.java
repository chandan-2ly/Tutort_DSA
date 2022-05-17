package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequnecesSum {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        List<Integer> result = getSubsequencesSum(arr);
        System.out.println(result);
    }

    private static List<Integer> getSubsequencesSum(int[] arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        int sum = 0;
//        getSubsequencesSumUtil(arr, subset, result, index, sum);
        getSubsequencesSumUtil2(arr, result, index, sum);
        return result;
    }

    private static void getSubsequencesSumUtil(int[] arr, List<Integer> subset, List<Integer> result, int index, int sum) {
        if(index >= arr.length){
            result.add(sum);
            return;
        }
        subset.add(arr[index]);
        sum += arr[index];
        getSubsequencesSumUtil(arr, subset, result, index + 1, sum);
        subset.remove(new Integer(arr[index]));
        sum -= arr[index];
        getSubsequencesSumUtil(arr, subset, result, index + 1, sum);
    }
    private static void getSubsequencesSumUtil2(int[] arr, List<Integer> result, int index, int sum) {
        if(index >= arr.length){
            result.add(sum);
            return;
        }
        sum += arr[index];
        getSubsequencesSumUtil2(arr, result, index + 1, sum);
        sum -= arr[index];
        getSubsequencesSumUtil2(arr, result, index + 1, sum);
    }
}
