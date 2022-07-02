package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};
        int result = getLargestRectangleArea2(heights);
        System.out.println(result);
    }

    private static int getLargestRectangleArea2(int[] heights) {
        int[] leftBoundary = new int[heights.length];
        int[] rightBoundary = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            storeBoundary(heights, stack, leftBoundary, i, true);
        }
        stack.clear();
        for(int i = heights.length - 1; i >= 0; i--){
            storeBoundary(heights, stack, rightBoundary, i, false);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int area = (rightBoundary[i] - leftBoundary[i] + 1) * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }

    private static void storeBoundary(int[] heights, Stack<Integer> stack, int[] boundary, int i, boolean isLeft) {
        if(stack.isEmpty()){
            stack.push(i);
            boundary[i] = isLeft ? 0 : heights.length-1;
        }
        else {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                boundary[i] = isLeft ? 0 : heights.length-1;
            else boundary[i] = isLeft ? stack.peek() + 1 : stack.peek() - 1;

            stack.push(i);
        }
    }

    public int getLargestRectangleArea(int[] heights) {
        int[] leftBoundary = getBoundaries(heights, true);
        int[] rightBoundary = getBoundaries(heights, false);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int area = (rightBoundary[i] - leftBoundary[i] + 1) * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }

    private static int[] getBoundaries(int[] heights, boolean isLeft) {
        Stack<Integer> stack = new Stack<>();
        int[] boundary = new int[heights.length];
        if(isLeft){
            for(int i = 0; i < heights.length; i++){
                if(stack.isEmpty()){
                    stack.push(i);
                    boundary[i] = 0;
                }
                else {
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        boundary[i] = 0;
                    else boundary[i] = stack.peek() + 1;

                    stack.push(i);
                }
            }
        }
        else {
            for(int i = heights.length - 1; i >= 0; i--){
                if(stack.isEmpty()){
                    stack.push(i);
                    boundary[i] = heights.length-1;
                }
                else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        boundary[i] = heights.length-1;
                    else boundary[i] = stack.peek() - 1;

                    stack.push(i);
                }
            }
        }
        return boundary;
    }
}
