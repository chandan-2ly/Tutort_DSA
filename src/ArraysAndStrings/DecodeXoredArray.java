package ArraysAndStrings;

import java.util.Arrays;

public class DecodeXoredArray {
    public static void main(String[] args){
        int[] encoded = {1,2,3};
        int first = 1;
        int[] result = getDecodedArray(encoded, first);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getDecodedArray(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for(int i = 0; i < encoded.length; i++){
            for(int j = 0; ;j++){
                if((j ^ result[i]) == encoded[i]){
                    result[i+1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
