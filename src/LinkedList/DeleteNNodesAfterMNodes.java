package LinkedList;

public class DeleteNNodesAfterMNodes {
    public static void main(String[] args){
        ListNode list = new ListNode(9);
        list.next = new ListNode(1);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(9);
        list.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next = new ListNode(10);
        list.next.next.next.next.next.next.next = new ListNode(1);

        int m = 6, n = 3;
        System.out.println("Before");
        ListNode.Display(list);
        System.out.println("After");
        getDeletedNode(list, m, n);
        ListNode.Display(list);
    }

    private static void getDeletedNode(ListNode head, int M, int N) {
        if(head == null)
            return;
        ListNode currM = head;
        while (currM != null){
            int countM = 1;
            while (currM != null && countM < M){
                currM = currM.next;
                countM++;
            }
            if(currM == null)
                return;
            ListNode currN = currM.next;
            int countN = 1;

            while (currN != null && countN <= N){
                currN = currN.next;
                countN++;
            }

            currM.next = currN;
            currM = currN;
        }


    }
}
