package ArraysAndStrings;

public class ReverseCharArray {
    public static void main(String[] args){
        char[] array = {'a','b','c','d','e','f'};
        reverseCharArray(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    public static char[] reverseCharArray(char[] array){
        int i = 0, j = array.length-1;
        while(i < j){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }
}
