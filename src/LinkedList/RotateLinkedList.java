package LinkedList;

//https://leetcode.com/problems/rotate-list/submissions/
public class RotateLinkedList {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }
        int k = 4;
        ListNode result = rotateList2(head, k);
        ListNode.Display(result);
    }

    private static ListNode rotateList(ListNode head, int k) {
        int count = getNodesCount(head);
        int pivot = k % count;
        if(pivot == 0) return head;

        //join pivot node from last

        ListNode fast = null;
        ListNode slow = null;

        for(int i = 0; i < pivot; i++){
            if(fast == null)
                fast = head;
            else{
                fast = fast.next;
            }

        }

        while(fast.next != null){
            fast = fast.next;
            if(slow == null){
                slow = head;
            }
            else{
                slow = slow.next;
            }
        }

        ListNode temp = head;
        head = slow.next;
        slow.next = null;
        fast.next = temp;

        return head;
    }
    private static ListNode rotateList2(ListNode head, int k) {
        if(head == null||head.next == null||k == 0) return head;
        //calculating length
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head;
        k = k%length; //when k is more than length of list
        int end = length-k; //to get end of the list
        while(end--!=0) temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;


        return head;
    }
    private static int getNodesCount(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
