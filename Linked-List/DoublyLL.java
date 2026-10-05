public class DoublyLL{
    Node head;
    Node tail;
    int size = 0;

    void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void removeFirst(){
        head = head.next;
    }

    void addLast(int data){
        Node newNode = new Node(data);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    void removeLast(){
        tail = tail.prev;
        tail.next = null;        
    }

    void print(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void reverseDLL(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String args[]){
        DoublyLL dll = new DoublyLL();

        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        
        dll.head = p1;
        dll.tail = p5;
        // System.out.println(dll.tail.data);

        // dll.print();
        // dll.addFirst(0);
        // dll.print();
        // dll.removeFirst();


        // dll.print();
        // dll.addLast(6);
        // dll.print();
        // dll.removeLast();
        dll.print();
        dll.reverseDLL();
        dll.print();
    }
}