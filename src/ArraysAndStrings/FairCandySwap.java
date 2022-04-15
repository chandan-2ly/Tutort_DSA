package ArraysAndStrings;

import java.util.Arrays;

public class FairCandySwap {
    public static void main(String[] args){
        int[] aliceSizes = {2};
        int[] bobSizes = {1,3};
        int[] result = fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(result));
    }
    private static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        for(int i = 0; i < aliceSizes.length; i++){
            aliceSum += aliceSizes[i];
        }
        for(int i = 0; i < bobSizes.length; i++){
            bobSum += bobSizes[i];
        }
        int[] result = new int[2];
        for(int i = 0; i < aliceSizes.length; i++){

            for(int j = 0; j < bobSizes.length; j++){
                int aliceTempSum = aliceSum - aliceSizes[i] + bobSizes[j];
                int bobTempSum = bobSum - bobSizes[j] + aliceSizes[i];
                if(aliceTempSum == bobTempSum){
                    result[0] = aliceSizes[i];
                    result[1] = bobSizes[j];
                    return result;
                }
            }
        }
        return result;
    }
}
