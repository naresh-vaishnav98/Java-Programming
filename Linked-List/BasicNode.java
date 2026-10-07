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

    void removeNthfromEnd(int n){
        int sz = 0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    Node midofLL(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //Find mid
        Node mid = midofLL();

        //reverse ssecond half
        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //check left and right
        Node left = head;
        Node right = prev;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    boolean checkCycleinLL(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    void removeCycle(){
        //Detect cycle
        Node slow = head;
        Node fast = head;

        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        if(isCycle = false){
            return;
        }

        Node prev = null;
        slow = head;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node merge(Node leftHead, Node rightHead){
        Node newNode = new Node(-1);
        Node temp = newNode;

        while(leftHead != null && rightHead != null){
            if(leftHead.data <= rightHead.data){
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while(leftHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while(rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return newNode.next;
    }

    Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // getMid
        Node midNode = getMid(head);
        Node rightHd = midNode.next;

        //divide in 2 parts
        midNode.next = null;
        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(rightHd);

        //merge
        return merge(leftHead, rightHead);
    }


    void zigzig(){
        // find mid and divide
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;
        Node rightHead = midNode.next;
        slow.next = null;

        // reverse second half
        Node prev = null;
        Node curr = rightHead;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge in zigzag fashion
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }


    //Intersection of Two Linked Lists
    public Node intersectingNode(Node head1, Node head2){
        Node curr1 = head1;
        Node curr2 = head2;

        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
            if(curr1 == null && curr2 == null){
                return null;
            }else if(curr1 == null){
                curr1 = head2;
            }else if(curr2 == null){
                curr2 = head1;
            }
        }
        return curr1;
    }

    //Delete N Nodes After M Nodes of a Linked List
    public void delete_N_Nodes(int m, int n){
        Node prev = null;
        Node curr = head;

        while(curr !=  null){
            for(int i = 0; i < m && curr != null; i++){
                prev = curr;
                curr = curr.next;
            }

            for(int i = 0; i < n && curr != null; i++){
                curr = curr.next;
            }

            prev.next = curr;
        }
    }

    //Swapping nodes in Linked list
    // public void swappingNodes(int key1, int key2){
    //     Node prev1 = null;
    //     Node prev2 = null;
    //     Node curr1 = head;
    //     Node curr2 = head;
        
    //     while(curr1.data != key1){
    //         prev1 = curr1;
    //         curr1 = curr1.next;
    //     }
    //     System.out.println("Curr1 : "+ curr1.data + " Prev1 : "+prev1.data);
    //     while(curr2.data != key2){
    //         prev2 = curr2;
    //         curr2 = curr2.next;
    //     }
    //     System.out.println("Curr2 : "+ curr2.data + " Prev2 : "+prev2.data);

    //     Node curr1nxt = curr1.next;
    //     Node curr2nxt = curr2.next;

    //     prev1.next = curr2;
    //     prev2.next = curr1;
    //     curr1.next = curr2nxt;
    //     curr2.next = curr1nxt;
    // }

    public void swappingNodes(int key1, int key2) {
        // 1. If both keys are the same, no need to swap
        if (key1 == key2) return;

        Node prev1 = null, curr1 = head;
        // Find key1 and its previous node safely
        while (curr1 != null && curr1.data != key1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node prev2 = null, curr2 = head;
        // Find key2 and its previous node safely
        while (curr2 != null && curr2.data != key2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        // 2. If either key is not found in the list, exit
        if (curr1 == null || curr2 == null) {
            System.out.println("One or both keys not found in the list!");
            return;
        }

        // 3. If key1 was not at the head, update prev1.next; otherwise update head
        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2; // curr2 is the new head
        }

        // 4. If key2 was not at the head, update prev2.next; otherwise update head
        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1; // curr1 is the new head
        }

        // 5. Swap the next pointers
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
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
        Node p5 = new Node(50);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;


        Node q1 = new Node(1);
        Node q2 = new Node(2);
        Node q3 = new Node(3);

        q1.next = q2;
        q2.next = q3;
        q3.next = p4;



        // p4.next = p2;

        // System.out.print(p1.next);
        LinkedList LL = new LinkedList();
        LinkedList LL1 = new LinkedList();
        LL.head = p1;
        // LL.tail = p4;

        LL1.head = q1;
        

        // LL.addFirst(20);
        // LL.addFirst(10);

        // LL.addLast(30);
        // LL.addLast(40);

        // LL.addInMiddle(25,2);

        // LL.removeFirst();
        // LL.removeLast();

        // LL.itertiveSearch(30);

        // Node temp = LL.head;
        // LL.recursiveSearch(40,0,temp);


        // LL.printLinkedlist();
        System.out.println("Size of the Linked list is : "+LL.size);
        // LL.reverseLL();
        // LL.removeNthfromEnd(3);
        // LL.printLinkedlist();


        // Node mid = LL.midofLL();
        // System.out.println("Mid is : "+mid.data);
        
        // System.out.println(LL.checkPalindrome());

        // System.out.println(LL.checkCycleinLL());
        // // LL.removeCycle();
        // System.out.println(LL.checkCycleinLL());
        

        // LL.head = LL.mergeSort(LL.head);
        LL.printLinkedlist();
        // LL.zigzig();
        // System.out.println("Zigzag Linked List : ");
        // LL.printLinkedlist();

        // System.out.println("List 2  : ");
        // LL1.printLinkedlist();
        // Node intrsct = LL.intersectingNode(LL.head,LL1.head);
        // System.out.println("Intersecting Node is : "+intrsct.data);

        // LL.delete_N_Nodes(1,1);
        // System.out.println("List after deleting : ");
        // LL.printLinkedlist();

        LL.swappingNodes(10,50);
        System.out.println("List after swapping : ");
        LL.printLinkedlist();
    }
}