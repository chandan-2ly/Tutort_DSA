package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<Integer> result = getMajorityElements(nums);
        System.out.println(result);
    }

    private static List<Integer> getMajorityElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > Math.floor(nums.length/3)){
                result.add(m.getKey());
            }
        }

        return result;
    }
}
