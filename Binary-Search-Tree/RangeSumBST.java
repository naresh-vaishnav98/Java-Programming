import java.util.*;

public class RangeSumBST {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }

    public static int rangeSumOfBST(Node root, int low, int high){
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }

        sum += rangeSumOfBST(root.left,low,high);
        sum += rangeSumOfBST(root.right,low,high);
        
        return sum;
    }
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.left = new Node(13);
        root.right.right = new Node(18);

        System.out.println("Range Sum of BST : "+rangeSumOfBST(root, 7, 15));
    }    
}
