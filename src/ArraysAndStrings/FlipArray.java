package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {
    public static void main(String[] agrs){
        String A = "111";
        ArrayList<Integer> result = getFlippedArray(A);
        System.out.println(result);
        //System.out.println(result);
    }

    private static ArrayList<Integer> getFlippedArray(String A) {
        ArrayList<Integer> list = new ArrayList();
        int[] ans = new int[2];
        boolean flag = true;

        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '0'){
                list.add(1);
                flag = false;
            }

            else
                list.add(-1);
        }
        if(flag){
            return new ArrayList<>();
        }

        int maxSum = 0;
        int currSum = 0;
        int left = 0, right = 0;

        for(int i = 0; i < list.size(); i++){
            currSum += list.get(i);

            if(currSum < 0){
                currSum = 0;
                left = i + 1;
            }

            else if(currSum > maxSum){
                maxSum = currSum;
                right = i;
                ans[0] = left+1;
                ans[1] = right+1;
            }
        }

        list.clear();
        list.add(ans[0]);
        list.add(ans[1]);
        return list;
    }
}
