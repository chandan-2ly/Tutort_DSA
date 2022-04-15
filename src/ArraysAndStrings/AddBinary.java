package ArraysAndStrings;
//https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args){
        String a = "1";
        String b = "111";
        String result = getBinarySum(a, b);
        System.out.println(result);
    }

    private static String getBinarySum(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 && j >= 0){
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(j) - '0';
            int sum = num1 + num2 + carry;
            carry = sum / 2;

            ans.append(sum % 2);
            i--;
            j--;
        }

        while(i >= 0){
            int num1 = a.charAt(i) - '0';
            int sum = num1 + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            i--;
        }
        while(j >= 0){
            int num1 = b.charAt(j) - '0';
            int sum = num1 + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            j--;
        }
        while(carry >= 1){
            ans.append(carry % 2);
            carry = carry / 2;
        }
        ans.reverse();
        return String.valueOf(ans);
    }
}
