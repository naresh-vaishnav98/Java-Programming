import java.util.*;

public class QueueByDeque{

    public static class Queue{
        static Deque<Integer> deq = new LinkedList<>();
        public static void add(int data){
            deq.addLast(data);
        }

        public static int remove(){
            return deq.removeFirst();
        }

        public static int peek(){
            return deq.getFirst();
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        
        System.out.println("Peek : "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}