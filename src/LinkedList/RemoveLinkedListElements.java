package LinkedList;

public class RemoveLinkedListElements {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(6);
        head.next.next.next = new ListNode(1);
        head = removeElements(head, 2);
        ListNode.Display(head);
    }

    private static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)
            head = head.next;

        if(head == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        if(head.next != null)
            next = curr.next;

        while(curr.next != null){
            if(curr.val == val){
                curr = curr.next;
                prev.next = next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
            next = next.next;
        }

        if(curr.val == val)
            prev.next = next;

        return head;
    }
}
