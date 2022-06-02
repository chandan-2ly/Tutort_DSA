package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l2.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        
        ListNode result = mergeKSortedList2(lists);
        ListNode.Display(result);
    }

    private static ListNode mergeKSortedList(ListNode[] lists) {
        if(lists.length <= 0) return null;

        int k = 1;
        while (lists.length > k){
            for (int i=0; i<lists.length-k; i+=k*2){
                ListNode a = lists[i];
                ListNode b = lists[i+k];
                lists[i]= mergeTwoLists(a, b);
            }
            k=k*2;
        }
        return lists[0];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val > l2.val){  //smaller must be l1
            //swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode result = l1;

        while(l1 != null && l2 != null ){
            ListNode prev = null;
            while(l1 != null && l1.val <= l2.val){
                prev = l1;
                l1 = l1.next;
            }
            prev.next = l2;

            //swap if l1 is greater than l2 to make smaller as l1
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return result;
    }

    private static ListNode mergeKSortedList2(ListNode[] lists) {
        if(lists.length <= 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int row = 0; row < lists.length; row++){
            heap.add(lists[row]);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (!heap.isEmpty()){
            ListNode temp = heap.poll();
            ListNode next = temp.next;
            curr.next = temp;
            curr = curr.next;
            if(next != null)
                heap.add(next);
        }
        return dummy.next;

    }

}
