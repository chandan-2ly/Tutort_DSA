package LinkedList;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reArrangeOddEven(head);
        ListNode.Display(head);
    }

    private static ListNode reArrangeOddEven(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        ListNode oddHead = head;
        ListNode oddTail = head;

        while(evenTail != null && evenTail.next != null){
            oddTail.next = oddTail.next.next;
            oddTail = oddTail.next;
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;
        return oddHead;
    }
}
