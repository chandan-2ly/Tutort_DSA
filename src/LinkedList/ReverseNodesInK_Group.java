package LinkedList;

import java.util.List;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInK_Group {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }
        int k = 3;
        ListNode result = reverseNodes(head, k);
        ListNode.Display(result);
    }

    private static ListNode reverseNodes(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        int nodesCount = getNodesCount(head);
        int loopCount = nodesCount/k;

        if (nodesCount < k) return head;
        ListNode dummyHead = new ListNode();
        ListNode ans = null;
        for (int i = 0; i  < loopCount; i++){
            int count = k;
            ListNode curr = head;
            ListNode next = null;
            ListNode prev = null;

            while (count > 0 && curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count--;
            }
            if(i == 0)
                ans = prev;
            dummyHead.next = prev;
            dummyHead = head;
            head.next = next;
            head = head.next;
        }

        return ans;
    }

//    private static ListNode reverseList(ListNode head, int k) {
//
//        return prev;
//    }

    private static int getNodesCount(ListNode head) {
        if(head == null) return 0;
        int count  = 0;
        ListNode curr = head;

        while (curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

}
