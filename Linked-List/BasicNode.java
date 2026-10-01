class LinkedList{
    Node head;
    
    void printLinkedlist(){
        Node curr = this.head;

        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class BasicNode{
    public static void main(String args[]){
        Node p1 = new Node(10);
        Node p2 = new Node(20);
        Node p3 = new Node(30);
        Node p4 = new Node(40);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        // System.out.print(p1.next);
        LinkedList LL = new LinkedList();
        LL.head = p1;
        LL.printLinkedlist();
    }
}