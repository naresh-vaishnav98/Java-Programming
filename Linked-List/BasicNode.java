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

    

    void removeFirst(){
        if(size == 0){
            System.out.println("Linked List is empty!!");
            return;
        }else if(size == 1){
            head = tail = null;
            size = 0;
            return;
        }
        head = head.next;
        size--;
    }

    void removeLast(){
        if(size == 0){
            System.out.println("Linked List is empty!!");
            return;
        }else if(size == 1){
            head = tail = null;
            size = 0;
            return;
        }

        Node prev = head;
        for(int i = 0; i < size-2; i++){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev.next;
        size--;
    }

    void itertiveSearch(int num){
        Node curr = head;

        for(int i = 0; i < size; i++){
            if(curr.data == num){
                System.out.println("Element found at Index : "+i);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Element Not Found !!");
        return;
    }

    void recursiveSearch(int num, int idx, Node temp){
        if(temp == null){
            System.out.println("Element Not Found !!");
            return;
        }
        if(temp.data == num){
            System.out.println("Element found at Index : "+idx);
            return;
        }
        temp = temp.next;
        recursiveSearch(num,idx+1,temp);

    }

    void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
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
        

        LL.addFirst(20);
        LL.addFirst(10);

        LL.addLast(30);
        LL.addLast(40);

        LL.addInMiddle(25,1);

        // LL.removeFirst();
        // LL.removeLast();

        // LL.itertiveSearch(30);

        // Node temp = LL.head;
        // LL.recursiveSearch(40,0,temp);


        LL.printLinkedlist();
        LL.reverseLL();
        LL.printLinkedlist();
        System.out.print("Size of the Linked list is : "+LL.size);
    }
}