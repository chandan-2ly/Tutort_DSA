package ArraysAndStrings;

public class ReverseOnlyVowels {
    public static void main(String[] args){
        String s = "Aeiou";
        s = reverseVowels(s);
        System.out.println(s);
    }

    private static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j){
            char charAtStart = charArray[i];
            char charAtEnd = charArray[j];
            if(isVowel(charAtStart) && isVowel(charAtEnd)){
                swap(charArray, i, j);
                i++;
                j--;
            }
            if(!isVowel(charAtStart)){
                i++;
            }
            if(!isVowel(charAtEnd)){
                j--;
            }
        }
        return String.valueOf(charArray);
    }

    private static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }

    private static void swap(char[] charArray, int i, int j){
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
