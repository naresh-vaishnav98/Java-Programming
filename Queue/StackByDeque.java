import java.util.*;


public class StackByDeque{

    public static class Stack{
        static Deque<Integer> deq = new LinkedList<>();

        public static void push(int data){
            deq.addLast(data);
        }

        public static int pop(){
            return deq.removeLast();
        }

        public static int peek(){
            return deq.getLast();
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("Peek : " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}