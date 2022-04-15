package ArraysAndStrings;

import java.util.*;

//https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
public class ReduceArraySizeToHalf {
    public static void main(String[] args){
        int[] nums = {1000,1000,3,7};
        int result = getCountOfElementsToReduceArraySize(nums);
        System.out.println(result);
    }

    private static int getCountOfElementsToReduceArraySize(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        List<Integer> freq = new ArrayList<>();
        int count = 1;
        int start = 0, end = 1;
        while(end < arr.length){
            if(arr[start] == arr[end]){
                count++;
            }
            else{
                freq.add(count);
                start = end;
                count = 1;
            }
            end++;
        }
        freq.add(count);

        Collections.sort(freq, Collections.reverseOrder());

        int length = arr.length;
        for(int i = 0; i < freq.size(); i++){
            length -= freq.get(i);
            ans++;
            if(length <= arr.length/2){
                return ans;
            }
        }
        return 1;
    }
}
