package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrapRainWater {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        int result = getTrappedWater(nums);
        System.out.println(result);

    }

    private static int getTrappedWater(List<Integer> A) {
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        int n = A.size();

        int maxLeft = A.get(0);
        int maxRight = A.get(n-1);

        left.add(maxLeft);
        right.add(maxRight);

        for(int i = 1; i < A.size(); i++){
            maxLeft = Math.max(maxLeft, A.get(i));
            left.add(maxLeft);
        }

        for(int i = n-2; i >= 0; i--){
            maxRight = Math.max(maxRight, A.get(i));
            right.add(maxRight);
        }
        Collections.reverse(right);

        int trap = 0;

        for(int i = 0; i < n; i++){
            trap += Math.min(left.get(i), right.get(i)) - A.get(i);
        }

        return trap;
    }
}
