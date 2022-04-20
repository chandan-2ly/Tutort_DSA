package LinkedList;

public class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
    public static void Display(Node head){
        if(head == null){
            System.out.println("[]");
            return;
        }
        Node curr = head;
        while(curr.bottom != null){
            System.out.print(curr.data+"->");
            curr = curr.bottom;
        }
        System.out.print(curr.data);
    }

    public static Node AddElementToNext(Node head, int num){
        Node temp = new Node(num);
        if(head == null){
            head = temp;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head;
    }
    public static Node AddElementToBottom(Node head, int num){
        Node temp = new Node(num);
        if(head == null){
            head = temp;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head;
    }
}
