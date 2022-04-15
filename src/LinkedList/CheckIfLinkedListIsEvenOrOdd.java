package LinkedList;

public class CheckIfLinkedListIsEvenOrOdd {
    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(6);
        head.next.next = new Node(6);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(6);
        checkOddEven(head);
    }

    private static void checkOddEven(Node head) {
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
        }

        if(fast.next == null){
            System.out.println("Odd");
            return;
        }
        System.out.println("even");
    }
}
