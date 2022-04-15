package ArraysAndStrings;

public class SumOfStringDigits {
    public static void main(String[] args){
        String s = "qhquvppzooyt";
        int k = 6;
        int result = getSumOfStringDigitsAfterConvert(s, k);
        System.out.println(result);
    }

//    private static int getSumOfStringDigitsAfterConvert(String s, int k) {
//        String str = "";
//        for(int i = 0; i < s.length(); i++){
//            char ch = s.charAt(i);
//            str += Integer.toString(ch - 96);
//        }
//        char[] charArray = str.toCharArray();
//        int sum = 0;
//
//        for(int i = 0; i < charArray.length; i++){
//            sum += Character.getNumericValue(charArray[i]);
//        }
//        k--;
//        int rem = 0;
//        if(k == 0){
//            return sum;
//        }
//        else{
//            while(k > 0){
//                rem = 0;
//                while(sum > 0){
//                    rem += sum % 10;
//                    sum = sum / 10;
//                }
//                sum = rem;
//                k--;
//            }
//        }
//        return rem;
//    }

    private static int getSumOfStringDigitsAfterConvert(String s, int k){
        String str = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            str += Integer.toString(ch - 96);
        }

        if(str.length() == 1) return Character.getNumericValue(str.charAt(0));
        int sum = 0;

        return sum;
    }
}
