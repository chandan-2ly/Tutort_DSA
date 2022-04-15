package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode result = getAddedList(l1, l2);
        ListNode.Display(result);
    }

    private static ListNode getAddedList(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result =  new ListNode();
        ListNode resultHead = result;

        ListNode currL1 = l1;
        ListNode currL2 = l2;

        while(currL1 != null && currL2 != null){
            int sum = currL1.val + currL2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            resultHead.next = new ListNode(rem);
            resultHead = resultHead.next;

            currL1 = currL1.next;
            currL2 = currL2.next;
        }

        while(currL1 != null){
            int sum = currL1.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            resultHead.next = new ListNode(rem);
            resultHead = resultHead.next;

            currL1 = currL1.next;
        }

        while(currL2 != null){
            int sum = currL2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            resultHead.next = new ListNode(rem);
            resultHead = resultHead.next;

            currL2 = currL2.next;
        }

        if(carry == 1)
            resultHead.next = new ListNode(1);

        return result.next;
    }


}
