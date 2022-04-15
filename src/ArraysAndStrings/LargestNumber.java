package ArraysAndStrings;

public class LargestNumber {
    public static void main(String[] args){
        int[] nums = {432,43243};
        String result = largestNumber(nums);
        System.out.println(result);
    }
    private static String largestNumber(int[] nums) {
        String result = "";
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                String ijVal = Integer.toString(nums[i]) + Integer.toString(nums[j]);
                String jiVal = Integer.toString(nums[j]) + Integer.toString(nums[i]);

                if(jiVal.compareTo(ijVal) > 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        if(nums[0] == 0)
            return "0";

        for(int i = 0; i < nums.length; i++){
            result += Integer.toString(nums[i]);
        }

        return result;
    }
//    private static String largestNumber(int[] nums) {
//        long[] result = new long[9];
//
//        for(int i = 0; i < 9; i++){
//            result[i] = -1;
//        }
//
//        for(int i = 0; i < nums.length; i++){
//            if((nums[i] / 10 == 0) && nums[i] % 10 == nums[i]){     //single digit
//                if(result[nums[i] - 1] == -1)
//                    result[nums[i] - 1] = nums[i];
//                else{
//                    long val = result[nums[i] - 1];
//                    long placedNumber = getPlacedNumber(val, nums[i]);
//                    result[nums[i] - 1] = placedNumber;
//                }
//            }
//            else if(nums[i] / 10 > 0){
//                int val = nums[i] / 10;
//                if(result[val - 1] == -1)
//                    result[val - 1] = nums[i];
//                else{
//                    long placedNumber = getPlacedNumber(result[val - 1], nums[i]);
//                    result[val - 1] = placedNumber;
//                }
//            }
//        }
//        String s = "";
//        for (int i = 8; i >= 0; i--){
//            if(result[i] != -1)
//                s += Long.toString(result[i]);
//        }
//        return s;
//    }
    private static long getPlacedNumber(long number, int numberToBePlaced){
        long result = 0;
        long leftPlacement = Long.parseLong(Long.toString(number) + Long.toString(numberToBePlaced));
        long rightPlacement = Long.parseLong(Long.toString(numberToBePlaced) + Long.toString(number));
        if(leftPlacement > rightPlacement){
            result = leftPlacement;
        }
        else result = rightPlacement;
        return result;
    }
}
