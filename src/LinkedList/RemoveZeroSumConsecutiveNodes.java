package LinkedList;

import java.util.HashMap;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class RemoveZeroSumConsecutiveNodes {
    public static void main(String[] args){
        int[] nums = {1,2,3,-3,-2};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }

        head = getListAfterRemovingConsecutiveZeroSum(head);
        ListNode.Display(head);
    }

    private static ListNode getListAfterRemovingConsecutiveZeroSum(ListNode head) {
        ListNode prev = new ListNode(0);
        HashMap<Integer, ListNode> map = new HashMap();
        prev.next = head;
        map.put(0, prev);

        int sum = 0;
        while(head != null){
            sum += head.val;
            if(map.containsKey(sum)){
                ListNode curr = map.get(sum);
                int s = sum;
                while(curr != null && curr != head){
                    curr = curr.next;
                    s += curr.val;
                    if(curr != head){
                        map.remove(s);
                    }
                }
                map.get(sum).next = head.next;
            }
            else{
                map.put(sum, head);
            }
            head = head.next;
        }

        return prev.next;
    }
}
