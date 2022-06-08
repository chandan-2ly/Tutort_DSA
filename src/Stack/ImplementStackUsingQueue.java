package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    public static void main(String[] args){
        MyStackUsingSingleQueue obj = new MyStackUsingSingleQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        obj.push(3);
        System.out.println(obj.top());
        System.out.println(obj.empty());

        MyStackUsingDoubleQueue obj2 = new MyStackUsingDoubleQueue();
        obj2.push(1);
        obj2.push(2);
        System.out.println(obj2.top());
        System.out.println(obj2.pop());
        obj2.push(3);
        System.out.println(obj2.top());
        System.out.println(obj2.empty());

    }
}
class MyStackUsingDoubleQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStackUsingDoubleQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
class MyStackUsingSingleQueue {

    private Queue<Integer> queue1;

    public MyStackUsingSingleQueue() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        for(int i = 0; i < queue1.size()-1; i++){
            queue1.add(queue1.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
