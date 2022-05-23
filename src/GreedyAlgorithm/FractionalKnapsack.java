package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Item
{
    int weight;
    int value;
    Item(int weight, int value)
    {
        this.weight = weight;
        this.value = value;
    }

}
class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b)
    {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}
public class FractionalKnapsack {
    public static void main(String[] args){
        int n = 6;
        int w = 200;
        Item[] items = {new Item(50, 40), new Item(40, 50),
                new Item(90, 25),new Item(120, 100),
                new Item(10, 30), new Item(200, 45)};

        double result = getMaxSum(items, n, w);
        System.out.println(result);
    }

    private static double getMaxSum(Item[] arr, int n, int W) {
        Arrays.sort(arr, new itemComparator());
        double sum = 0;
        int i = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i].weight <= W){
                W -= arr[i].weight;
                sum += arr[i].value;
            }
            else{
                sum += ((double) arr[i].value/(double) arr[i].weight) * W;
                break;
            }
        }
        return sum;
    }
}
