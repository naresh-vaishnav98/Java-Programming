class LinkedList{
    Node head;
    Node tail;
    int size;
    
    void printLinkedlist(){
        Node curr = this.head;

        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    void addInMiddle(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node curr = head;
        int i = 0;
        while(i != idx-1){
            curr = curr.next;
            i++;
        }
        
        newNode.next = curr.next;
        curr.next = newNode;
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
        // Node p1 = new Node(10);
        // Node p2 = new Node(20);
        // Node p3 = new Node(30);
        // Node p4 = new Node(40);

        // p1.next = p2;
        // p2.next = p3;
        // p3.next = p4;

        // System.out.print(p1.next);
        LinkedList LL = new LinkedList();
        // LL.head = p1;
        // LL.tail = p4;
        

        LL.addFirst(50);
        LL.addFirst(60);

        LL.addLast(70);
        LL.addLast(80);

        LL.addInMiddle(25,1);

        LL.printLinkedlist();
        System.out.print("Size of the Linked list is : "+LL.size);
    }
}