package ArraysAndStrings;

public class RemoveDigitFromNumber {
    public static void main(String[] args){
        String number = "1031";
        char digit = '1';
        String result = removeDigitFromNumber(number, digit);
        System.out.println(result);
    }

    private static String removeDigitFromNumber(String number, char digit) {
        String ans = "0";
        StringBuilder str = new StringBuilder(number);
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == digit){
                str.deleteCharAt(i);
                if(Integer.parseInt(String.valueOf(str)) >Integer.parseInt(ans)){
                    ans = String.valueOf(str);
                }
                str.insert(i, digit);
            }
        }
        return ans;
    }
}
