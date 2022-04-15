package ArraysAndStrings;

public class MultiplyStrings {
    public static void main(String[] args){
        String num1 = "12";
        String num2 = "456";

        String result = getProductOfStrings(num1, num2);
        System.out.println(result);
    }

    private static String getProductOfStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;

        int[] productArray = new int[m + n];

        StringBuilder result = new StringBuilder();
        int powerFactor = productArray.length - 1;

        for(int i = n - 1 ; i >= 0; i--) {
            char ch1 = num1.charAt(i);
            int carry = 0;
            int k = powerFactor;
            for(int j = m - 1 ; j >= 0; j--) {

                char ch2 = num2.charAt(j);

                int prod = (ch1 - '0') * (ch2 - '0') + carry + productArray[k];
                carry = prod / 10;
                productArray[k] = prod % 10;
                k--;
            }
            if(carry != 0)
                productArray[k] = carry;
            powerFactor--;
        }

        boolean isLeadingZero = true;
        for (int num : productArray) {
            if(num == 0 && isLeadingZero) {
                continue;
            } else {
                result.append(num);
                isLeadingZero = false;
            }
        }

        return String.valueOf(result);
    }
}
