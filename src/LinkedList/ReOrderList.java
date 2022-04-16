package LinkedList;

import java.util.HashMap;

//https://leetcode.com/problems/reorder-list/
//https://www.interviewbit.com/problems/reorder-list/
public class ReOrderList {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }

        ListNode result = reOrderList3(head);
        ListNode.Display(result);
    }

    private static ListNode reOrderList(ListNode head) {
        ListNode copy = cloneOriginalList(head);
        ListNode reverseList = reverseList(copy);
        int count = getNodesCount(head);

        ListNode currHead = head;
        ListNode currRev = reverseList;
        int k = 1;

        while (count > 1){
            ListNode cHNext = currHead.next;
            ListNode cRNext = currRev.next;
            currHead.next = currRev;
            count--;
            if(count == 1) {
                currRev.next = null;
                break;
            }
            currRev.next = cHNext;
            count--;
            if(count == 1) {
                cHNext.next = null;
                break;
            }
            currHead = cHNext;
            currRev = cRNext;
        }

        return head;

    }

    private static ListNode reOrderList2(ListNode head) {
        int count = getNodesCount(head);

        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 1;
        ListNode curr = head;

        while (i <= count){
            map.put(i, curr);
            curr = curr.next;
            i++;
        }
        curr = head;
        i = 1;
        int j = count;

        ListNode dummy = new ListNode();
        ListNode dummyCurr = dummy;

        while (i < j){
            dummyCurr.next = map.get(i);
            i++;
            dummyCurr = dummyCurr.next;
            dummyCurr.next = map.get(j);
            j--;
            dummyCurr = dummyCurr.next;
        }

        if(i == j)
        {
            dummyCurr.next = map.get(i);
            dummyCurr = dummyCurr.next;
        }

        dummyCurr.next = null;
        return dummy.next;

    }

    private static ListNode reOrderList3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverseList(slow.next); //reverse the list after mid
        ListNode currHead = head;
        ListNode revCurr = revHead;
        ListNode orgNext = null;
        ListNode revNext = null;
        ListNode prev = null;

        slow.next = null;

        while (currHead != null && revCurr != null){
            orgNext = currHead.next;
            revNext = revCurr.next;
            currHead.next = revCurr;
            revCurr.next = orgNext;

            //storing last value of linked list
            prev = currHead;
            currHead = orgNext;
            revCurr = revNext;
        }

        //if the list count is even, then in second half one node will be remaining
//        if(revCurr != null){
//            prev.next = revCurr;
//        }

        return head;
    }

    private static int getNodesCount(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode cloneOriginalList(ListNode head) {
        ListNode curr = head;
        ListNode copy = new ListNode();
        ListNode copyCurr = copy;

        while (curr != null){
            ListNode temp = new ListNode(curr.val);
            copyCurr.next = temp;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return copy.next;
    }
}
