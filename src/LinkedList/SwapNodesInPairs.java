package LinkedList;

//https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public static void main(String[] args){
        int[] nums = {28, 34, 48, 74, 42, 49, 37, 59, 97, 96, 73, 44, 39, 50, 80, 30,
                95, 26, 94, 88, 87, 84, 57, 47, 100, 56, 69, 27, 58, 2, 64, 86, 8, 43, 41, 32,
                67, 51, 53, 101, 7, 76, 92, 45, 83, 6, 46, 40, 16, 66, 91, 1, 63, 89, 90, 4, 52,
                65, 3, 70, 62, 29, 71, 15, 22, 93, 24, 25, 61, 82, 54, 60, 81, 14, 33, 85, 13, 17,
                20, 31, 18, 79, 68, 10, 38, 11, 78, 72, 55, 36, 19, 99, 77, 5, 12, 35, 23, 21, 98 };
        ListNode head = null;
        for(int num : nums){
            head = ListNode.AddElement(head, num);
        }
        
        ListNode result = swapEveryPairs(head);
        ListNode.Display(result);
    }

    private static ListNode swapEveryPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while(curr != null && curr.next != null){

            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
