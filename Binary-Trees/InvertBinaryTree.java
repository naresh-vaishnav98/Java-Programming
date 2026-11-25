public class InvertBinaryTree {

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node invertTree(Node root){
        if(root == null){
            return null;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    
    public static void main(String args[]){
        InvertBinaryTree obj = new InvertBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(root.left.left.data);
        System.out.println(obj.invertTree(root).right.right.data);
    }
}
