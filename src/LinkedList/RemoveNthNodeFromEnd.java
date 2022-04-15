package LinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class RemoveNthNodeFromEnd {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head = removeNodeFromEnd(head, 2);
        ListNode.Display(head);
    }

    private static ListNode removeNodeFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        if(head.next == null && n == 1){
            head = null;
            return head;
        }

        ListNode fast = null;
        ListNode slow = null;

        for(int i = 0; i < n; i++){
            if(fast == null)
                fast = head;
            else
                fast = fast.next;
        }
        if(fast.next == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            if(slow == null)
                slow = head;
            else
                slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
