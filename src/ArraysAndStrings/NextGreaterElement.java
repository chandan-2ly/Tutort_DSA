package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement {
    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = getNextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getNextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        int[] nextGreater = new int[nums2.length];

        for(int i = 0; i < nums2.length; i++){
            boolean flag = false;
            for(int j = i + 1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    nextGreater[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nextGreater[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] =  nextGreater[map.get(nums1[i])];
        }
        return result;
    }
}
