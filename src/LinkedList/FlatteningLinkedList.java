package LinkedList;

//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
public class FlatteningLinkedList {
    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);
        head.next.bottom = new Node(20);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        Node result = flattenList(head);
        Node.Display(result);
    }

    private static Node flattenList(Node root) {
        if(root == null) return null;
        if(root.next == null) return root;

        Node curr = root.next;
        Node result = root;

        while(curr != null){
            result = mergeTwoSortedList(result, curr);
            curr = curr.next;
        }
        return result;
    }

    private static Node mergeTwoSortedList(Node headA, Node headB) {
        Node l1 = headA;
        Node l2 = headB;

        if(l1.data > l2.data){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node result = l1;

        while(l1 != null && l2 != null){
            Node prev = null;
            while(l1 != null && l1.data <= l2.data){
                prev = l1;
                l1 = l1.bottom;
            }

            prev.bottom = l2;

            //swap
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return result;
    }
}
