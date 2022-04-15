package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOneToNumber {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int[] result = getSum(nums);
        System.out.println(Arrays.toString(result));
    }
    private static int[] getSum(int[] A){
        int carry = 1;
        int i = A.length - 1;

        while(i >= 0 && carry == 1){
            A[i] = A[i] + carry;
            if(A[i] == 10){
                A[i] = 0;
                carry = 1;
            }
            else{
                carry = 0;
            }
            i--;
        }

        List<Integer> result = new ArrayList<Integer>();

        if(carry == 1){
            result.add(carry);
        }

        boolean isFirst = true;
        for(int j = 0; j < A.length; j++){
            if(A[j] == 0 && isFirst == true && carry == 0){
                continue;
            }
            else{
                result.add(A[j]);
                isFirst = false;
            }
        }

        int[] res = new int[result.size()];
        for(int j = 0; j < res.length; j++){
            res[j] = result.get(j);
        }
        return res;
    }
}
