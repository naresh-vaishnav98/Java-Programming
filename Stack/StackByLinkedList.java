public class StackByLinkedList{

    public static class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            if(head == null){
                return true;
            }
            return false;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }else{
                newNode.next = head;
                head = newNode;
            }
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top;
            top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            return top;
        }
    }
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        while(!(s.isEmpty())){
            System.out.println(s.peek());
            s.pop();
        }
    }
}