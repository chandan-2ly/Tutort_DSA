package LinkedList;

//https://leetcode.com/problems/partition-list/submissions/
public class PartitionList {
    public static void main(String[] args){
        int[] nums = {5,6,2,3,1};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }
        int x = 3;
        ListNode result = getPartionList(head, x);
        ListNode.Display(result);
    }

    private static ListNode getPartionList(ListNode head, int x) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null && curr.val < x){
                prev = curr;
                curr = curr.next;
        }
        if(curr == null) return head;

        ListNode pivot = curr;
        ListNode pivotPrev = prev;

        prev = curr;
        curr = pivot.next;

        while (curr != null){
            if(curr.val < x){
                if(pivotPrev == null){
                    head = curr;
                    pivotPrev = head;
                }
                else
                {
                    pivotPrev.next = curr;
                    pivotPrev = pivotPrev.next;
                }
                ListNode next = curr.next;
                curr.next = pivot;
                curr = next;
            }
            else {
                prev.next  = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = null;
        return head;
    }
}
