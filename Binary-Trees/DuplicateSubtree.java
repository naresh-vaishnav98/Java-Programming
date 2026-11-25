import java.util.*;

public class DuplicateSubtree {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static String helper(Node root){
        if(root == null){
            return "#";
        }

        String left = helper(root.left);
        String right = helper(root.right);

        String serial = root.data + "," + left + "," + right;
        int count = map.getOrDefault(serial,0) + 1;
        map.put(serial, count);

        if(count == 2){
            result.add(root.data);
        }
        return serial;
    }

    public static void main(String args[]){
        DuplicateSubtree obj = new DuplicateSubtree();

        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);

        obj.helper(root);

        System.out.println(result);
    }
}
