package ArraysAndStrings;

import java.util.Arrays;

public class PrisonAfterNDays {
    public static void main(String[] args){
        int nums[] = {0,1,0,1,1,0,0,1};
        int n = 7;
        int[] result = getPrisonAfterNDays(nums, n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getPrisonAfterNDays(int[] cells, int n) {
        int days = 1;
        while(days <= n){
            int[] temp = new int[cells.length];
            temp[0] = 0;
            temp[temp.length - 1] = 0;

            for(int i = 1; i < cells.length - 1; i++){
                if(cells[i - 1] == cells[i + 1])
                    temp[i] = 1;
                else
                    temp[i] = 0;
            }
            cells = temp;
            days++;
        }

        return cells;
    }
}
