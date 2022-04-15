package ArraysAndStrings;

//https://leetcode.com/problems/ones-and-zeroes/
public class OnesAndZeros {
    public static void main(String[] args){
        String[] strs = {"10","0","1"};
        int m = 1, n = 1;
        int count = findMaxForm(strs, m, n);
        System.out.println(count);
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        int min = Math.min(m,n);

        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() > (m + n)) continue;
            if(strs[i].length() <= min) count++;
            else{
                int zeroCount = 0;
                int oneCount = 0;
                for(int j = 0; j < strs[i].length(); j++){
                    if(strs[i].charAt(j) == '0') zeroCount++;
                    else oneCount++;

                    if(zeroCount > m || oneCount > n) break;
                }
                if(zeroCount <= m && oneCount <= n) count++;
            }

        }
        return count;
    }
}
