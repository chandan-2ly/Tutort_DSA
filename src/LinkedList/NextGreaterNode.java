package LinkedList;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.*;

//https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNode {
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        int[] result = getNextGreaterNodeArray(head);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getNextGreaterNodeArray(ListNode head) {
        if(head.next == null){
            return new int[]{0};
        }
        List<Integer> result = new ArrayList();
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            while(temp != null){
                if(temp.val > curr.val){
                    result.add(temp.val);
                    break;
                }
                temp = temp.next;
            }
            if(temp == null){
                result.add(0);
            }
            curr = curr.next;
        }

        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }

        return ans;
    }

    private static int[] getNextGreaterNodeArray2(ListNode head) {
        if(head.next == null){
            return new int[]{0};
        }
        List<Integer> nums = new ArrayList();
        ListNode curr = head;

        while (curr != null){
            nums.add(curr.val);
            curr = curr.next;
        }
        //int[] arr = new int[nums.size()];
//        for (int i = 0; i < nums.size(); i++){
//            arr[i] = nums.get(i);
//        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.size()];
        int n = ans.length;

        for(int i = n - 1; i >= 0; i--){
            while (!stack.empty() && stack.peek() <= nums.get(i)){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = stack.peek();
            }
            else ans[i] = 0;

            stack.push(nums.get(i));
        }

        return ans;

    }
}
