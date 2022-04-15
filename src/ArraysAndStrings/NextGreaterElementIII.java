package ArraysAndStrings;

//https://leetcode.com/problems/next-greater-element-iii/
public class NextGreaterElementIII {
    public static void main(String[] args){
        int n = 2147483486;
        int result = getNextGreaterElement(n);
        System.out.println(result);
    }

    private static int getNextGreaterElement(int n) {
        String num = Integer.toString(n);
        if(num.length() < 2) return -1;
        char[] charArray = num.toCharArray();
        int i = num.length() - 2;
        while(i >= 0 && (charArray[i] >= charArray[i+1])) i--;
        if(i >= 0){
            int j = num.length() - 1;
            while (j >= 0 && (charArray[j] <= charArray[i])) j--;

            swap(charArray, i, j);
        }
        reverse(charArray, i+1);

        long result = Long.parseLong(new String(charArray));
        if(result > Integer.MAX_VALUE) return -1;
        return Integer.parseInt(new String(charArray));
    }

    private static void reverse(char[] num, int i) {
        int j = num.length - 1;
        while(i < j){
            swap(num, i++, j--);
        }
    }

    private static void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
