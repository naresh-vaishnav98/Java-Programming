import java.util.*;

public class AVL_Tree {

    public static class Node{
        int data;
        int height = 1;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static int height(Node root){
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    public static int bf(Node root){
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    //In case of LL heavy
    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Rotate
        x.right = y;
        y.left = T2;

        x.height = Math.max(height(x.left) , height(x.right)) + 1;
        y.height = Math.max(height(y.left) , height(y.right)) + 1;
        
        return x;
    }

    //In case of RR heavy
    public static Node leftRotate(Node y){
        Node x = y.right;
        Node T1 = x.left;

        //Rotate
        x.left = y;
        y.right = T1;

        x.height = Math.max(height(x.left), height(x.right));
        y.height = Math.max(height(y.left), height(y.right));

        return x;
    }

    public static Node insertNode(Node root, int val){
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = insertNode(root.left,val);
        }else if (root.data < val) {
            root.right = insertNode(root.right, val);
        }else{
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = bf(root);

        //LL
        if (bf > 1 && val < root.left.data) {
            return rightRotate(root);
        }

        //RR
        if (bf < -1 && val > root.right.data) {
            return leftRotate(root);
        }

        //LR
        if (bf > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL
        if (bf < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static Node minValue(Node root){
        Node curr = root;
        while (curr != null) {
            curr = curr.left;
        }

        return curr;
    }

    public static Node deleteNode(Node root, int key){
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            deleteNode(root.left, key);
        }else if (root.data > key) {
            deleteNode(root.right, key);
        }else{
            if (root.left == null || root.right == null) {
                Node temp = (root.left == null) ? root.right : root.left;

                if (temp == null) {
                    root = null;
                }else{
                    root = temp;
                }
            }else{
                Node temp = minValue(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null) {
            return null;
        }


        // Update Height
        root.height = 1 + Math.max(height(root.left),height(root.right));

        int bf = bf(root);

        // LL Case
        if (bf > 1 && bf(root.left) >= 0) {
            return rightRotate(root);
        }

        // LR Case
        if (bf > 1 && bf(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR Case
        if (bf < -1 && bf(root.right) <= 0) {
            return leftRotate(root);
        }

        // RL Case
        if (bf < -1 && bf(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        insertNode(root, 2);
        insertNode(root, 3);
        insertNode(root, 4);
        insertNode(root, 5);
        insertNode(root, 6);
        // root.right = new Node(2);
        // root.right.right = new Node(3);
        // root.right.right.right = new Node(4);
        // root.right.right.right.right = new Node(5);

        System.out.println("Height of the AVL Tree : " + height(root));
        System.out.println("Balance Factor of the AVL Tree : " + bf(root));
    }    
}
