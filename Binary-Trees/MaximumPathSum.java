public class MaximumPathSum {

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }


    static int maxSum;

    public static int maxPathSum(Node root) {

        maxSum = Integer.MIN_VALUE;

        maxGain(root);

        return maxSum;
    }

    public static int maxGain(Node root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        int currentPath = root.data + left + right;

        maxSum = Math.max(maxSum, currentPath);

        return root.data + Math.max(left, right);
    }

    public static void main(String args[]){
        MaximumPathSum obj = new MaximumPathSum();

        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);

        System.out.println(maxPathSum(root));
    }
}
