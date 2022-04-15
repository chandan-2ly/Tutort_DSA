package LinkedList;

public class CycleAndOperationInLinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;

        boolean result = findCycle(head);
        System.out.println("Cycle Present: "+result);

        int length = getLengthOfCycle(head);
        System.out.println("Lenght of cycle is "+length);

        ListNode startingPointOfCycle = getStartingPointOfCycle(head);
        if (startingPointOfCycle != null) {
            System.out.println("Starting node of Cycle is" + startingPointOfCycle.val);
        } else {
            System.out.println("null");
        }

        removeCycle(head);

        ListNode.Display(head);
    }

    private static void removeCycle(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) break;
        }

        if(fast.next == null || fast.next.next == null) return;

        ListNode curr = head;

        if(curr != fast) {
            while (curr.next != fast.next) {
                curr = curr.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        else {
            while (fast.next != curr)
                fast = fast.next;
            fast.next = null;
        }
    }

    private static ListNode getStartingPointOfCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) break;
        }

        if(fast.next == null || fast.next.next == null) return null;

        ListNode curr = head;

        while (curr != fast){
            curr = curr.next;
            fast = fast.next;
        }
        return curr;
    }

    private static int getLengthOfCycle(ListNode head) {
        if(head == null || head.next == null) return 0;
        int count = 1;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) break;
        }
        if(fast.next == null || fast.next.next == null) return 0;

        while (slow.next != fast){
            count++;
            slow = slow.next;
        }
        return count;
    }

    private static boolean findCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;
        }
        return false;
    }
}
