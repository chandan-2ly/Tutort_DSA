package LinkedList;

import org.w3c.dom.ls.LSInput;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static void Display(ListNode head){
        if(head == null){
            System.out.println("[]");
            return;
        }
        ListNode curr = head;
        while(curr.next != null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.print(curr.val);
    }

    public static ListNode AddElement(ListNode head, int num){
        ListNode temp = new ListNode(num);
        if(head == null){
            head = temp;
        }
        else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head;
    }
}
