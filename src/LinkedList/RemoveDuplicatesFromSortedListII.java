package LinkedList;

//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,3};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }

        ListNode result = removeDuplicates(head);
        ListNode.Display(result);
    }

    private static ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        int val = Integer.MAX_VALUE;
        while (curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                val = curr.val;
                curr.next = curr.next.next;
            }
            else if(curr.val == val && prev != null){
                prev.next = curr.next;
                curr = curr.next;
            }
            else if(curr.val == val && prev == null){
                head = head.next;
                curr = head;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        if(curr != null && curr.val == val && prev == null){        //to handle 1,1 scenario
            head = head.next;
        }
        else if(curr != null && curr.val == val && prev != null){       //to handle 1,2,2 scenario
            prev.next = curr.next;
        }
        return head;
    }
}
