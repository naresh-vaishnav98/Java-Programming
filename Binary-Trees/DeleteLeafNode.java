public class DeleteLeafNode {

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node delNode(Node root, int x){
        if (root == null) {
            return null;
        }

        root.left = delNode(root.left, x);
        root.right = delNode(root.right, x);

        if(root.left == null && root.right == null && root.data == x){
            return null;
        }

        return root;
    }
    public static void main(String args[]){
        DeleteLeafNode obj = new DeleteLeafNode();

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        // System.out.println(root.left.left.data);

        System.out.println(obj.delNode(root, 3).left.right.data);
    }
}
