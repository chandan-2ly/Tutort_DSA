package PriorityQueue_Heap;

import java.util.PriorityQueue;
//https://leetcode.com/problems/find-median-from-data-stream/
public class FindMedianFromDataStream {
    public static void main(String[] args){
        MedianFinder mf = new MedianFinder();
        int[] nums = {-1,-2,-3,-4,-5};
        for(int num : nums) {
            mf.addNum(num);
            System.out.println(mf.findMedian());
        }
    }
}

class MedianFinder{
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();

        if(maxSize == 0){
            maxHeap.add(num);
        }
        else if (maxSize == minSize){
            if(num < minHeap.peek()){
                maxHeap.add(num);
            }
            else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }
        else {
            if (minHeap.size() == 0){
                if(num <= maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
                else {
                    minHeap.add(num);
                }
            }
            else if (num >= minHeap.peek()){
                minHeap.add(num);
            }
            else {
                if (num < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
                else
                    minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        double ans = 0.0;
        if(minHeap.size() == maxHeap.size()){
            ans = ((double)minHeap.peek() + (double) maxHeap.peek())/2;
        }
        else ans = (double) maxHeap.peek();
        return ans;
    }
}