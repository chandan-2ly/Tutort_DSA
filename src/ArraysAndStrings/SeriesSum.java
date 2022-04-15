package ArraysAndStrings;

public class SeriesSum {
    public static void main(String[] args){
        int N = 5;
        int result = getSum(N);
        System.out.println("Result "+result);
    }
    public static int getSum(int N){
        int sum = (N * (N + 1))/2;
//        int sum = 0;
//        for(int i = 1; i <= N; i++){
//            sum += i;
//        }
        return sum;
    }
}
