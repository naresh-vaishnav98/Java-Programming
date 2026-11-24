public class PracticeQuestions{
    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static boolean univalued(Node root, int val){
        if(root == null){
            return true;
        }

        if(root.data != val){
            return false;
        }

        boolean left = univalued(root.left, val);
        boolean right = univalued(root.right, val);

        return left && right;
    }
    public static void main(String args[]){

        PracticeQuestions p = new PracticeQuestions();

        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(2);


        System.out.println(p.univalued(root, 2));

    }
}