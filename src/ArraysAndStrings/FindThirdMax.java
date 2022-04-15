package ArraysAndStrings;

public class FindThirdMax {
    public static void main(String[] args){
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        Integer max = null, secondMax = null, thirdMax = null;

        for(Integer n : nums){
            if( n.equals(max) || n.equals(secondMax) || n.equals(thirdMax)) continue;
            if(max == null || n > max){
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            }
            else if(secondMax == null || n > secondMax){
                thirdMax = secondMax;
                secondMax = n;
            }
            else if(thirdMax == null || n > thirdMax){
                thirdMax = n;
            }
        }
        return thirdMax == null ? max : thirdMax;
    }
}
