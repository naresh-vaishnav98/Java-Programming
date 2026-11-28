import java.util.*;
import java.util.stream.Collectors;


public class ClosestElement {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }

    public static void storeDifference(Node root, int target, HashMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        map.put(root.data, Math.abs(root.data - target));

        storeDifference(root.left, target, map);
        storeDifference(root.right, target, map);
    }
    // public static int closestEle(Node root, int target, HashMap<Integer,Integer> map){
    //     if (root == null) {
    //         return -1;
    //     }

    //     map.put(root.data, Math.abs(root.data - target));
    //     closestEle(root.left,target,map);
    //     closestEle(root.right,target,map);

    //     map.entrySet()
    //         .stream()
    //         .sorted(Map.Entry.comparingByValue())
    //         .collect(Collectors.toMap(
    //             Map.Entry::getKey,
    //             Map.Entry::getValue,
    //             (e1, e2) -> e1, // Merge function (not used here, required by toMap)
    //             LinkedHashMap::new // Preserves the sorted order
    //         ));
        
        
    //          Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next();

    //     return firstEntry.getKey();
    // }

    public static int closestEle(Node root, int target) {

        if (root == null) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        storeDifference(root, target, map);

        Map.Entry<Integer, Integer> firstEntry = map.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get();

        return firstEntry.getKey();
    }
    public static void main(String args[]){
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.left = new Node(10);
        root.right.right = new Node(13);
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(closestEle(root,9));
    }    
}
