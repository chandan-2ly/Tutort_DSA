package ArraysAndStrings;

import java.util.HashMap;

public class LargestSubArrayWithKSum {
    public static void main(String[] args){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int k = 0;
        int maxSubArrayLength = getMaxSubArrayWithKSum(arr, k);
        System.out.println(maxSubArrayLength);
    }

    private static int getMaxSubArrayWithKSum2(int[] arr, int n) {  //it works for only positive integers
        int start = 0, end = 0, maxSize = 0, sum = 0;

        while(end < arr.length){
            sum += arr[end];

            if(sum < n){
                end++;
            }
            else if(sum == n){
                maxSize = Math.max(maxSize, end-start+1);
                end++;
            }
            else if(sum > n){
                while(start < arr.length && sum > n){
                    sum -= arr[start];
                    start++;
                }
                end++;
            }
        }
        return maxSize;
    }
    private static int getMaxSubArrayWithKSum(int[] arr, int k) {        //it works for both positive and negative
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, maxSum = 0, i = 0;
        while (i < arr.length){
            sum += arr[i];

            if(sum == k)
                maxSum = i+1;

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)){
                maxSum = Math.max(maxSum, i - map.get(sum- k));
            }
            i++;
        }
        return maxSum;
    }
    private static int getMaxSubArrayWithZeroSum(int[] arr, int k) {        //it works for both positive and negative for 0 sum
        HashMap<Integer, Integer> map = new HashMap<>();
        k = 0;
        int sum = 0, maxSum = 0, i = 0;
        while (i < arr.length){
            sum += arr[i];

            if(sum == k)
                maxSum = i+1;

            if(map.containsKey(sum - k)){
                maxSum = Math.max(maxSum, i - map.get(sum- k));
            }
            else {
                map.put(sum, i);
            }
            i++;
        }
        return maxSum;
    }
}
