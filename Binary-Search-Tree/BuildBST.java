import java.util.*;

public class BuildBST {

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insertNode(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val < root.data){
            root.left = insertNode(root.left, val);
        }else{
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node searchNode(Node root, int target){
        if(root == null){
            return null;
        }

        if(root.data == target){
            return root;
        }
        
        if(root.data > target){
            return searchNode(root.left,target);
        }else{
            return searchNode(root.right,target);
        }
    }

    public static Node deleteNode(Node root, int key){
        // if (root == null) {
        //     return null;
        // }

        // if (root.data == key) {
        //     return root;
        // }

        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        }else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        }else{
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root = root.right;
            }else if (root.right == null) {
                return root = root.left;
            }

            Node InorderSuccessor = findInorderSuccessor(root.right);
            root.data = InorderSuccessor.data;
            root.right = deleteNode(root.right, InorderSuccessor.data);
            
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return ;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path){
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root){
        if (root == null) {
            return null;
        }

        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    //Sorted Array to balanced BST
    public static Node createBalancedBST(int arr[], int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, start, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);
        return root;
    }


    public static ArrayList<Integer> newInOrder(ArrayList<Integer> arr, Node root){
        if (root == null) {
            return arr;
        }
        newInOrder(arr, root.left);
        arr.add(root.data);
        newInOrder(arr, root.right);
        return arr;
    }

    public static Node convertToBalancedBST(ArrayList<Integer> arr, Node root){
        arr = newInOrder(arr, root);

        int[] array = arr.stream().mapToInt(Integer::intValue).toArray();
        return createBalancedBST(array,0,array.length-1);
    }
    public static void main(String args[]){
        int values[] = {5, 1, 3, 4, 2, 7};
        // int values[] = {8,5,3,6,10,11,14};
        Node root = null;


        for(int i = 0; i < values.length; i++){
            root = insertNode(root, values[i]);
        }
        
        inOrder(root);

        System.out.println();
        // System.out.println(searchNode(root, 7).data);

        System.out.println();
        // root = deleteNode(root, 5);
        // inOrder(root);

        System.out.println();
        printInRange(root,3,6);

        System.out.println();
        ArrayList<Integer> path = new ArrayList<>();
        rootToLeaf(root, path);

        System.out.println();
        System.out.print(isValidBST(root, null, null));

        System.out.println();
        System.out.println(mirrorBST(root).data);
        inOrder(root);

        System.out.println();
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        System.out.println("Balanced BST Root : "+createBalancedBST(arr,0,arr.length-1).data);
        inOrder(createBalancedBST(arr,0,arr.length-1));

        System.out.println();
        ArrayList<Integer> array = new ArrayList<>();
        Node newRoot = new Node(8);
        newRoot.left = new Node(6);
        newRoot.left.left = new Node(5);
        newRoot.left.left.left = new Node(3);
        newRoot.right = new Node(10);
        newRoot.right.right = new Node(11);
        newRoot.right.right.right = new Node(12);
        System.out.println(convertToBalancedBST(array,newRoot).right.right.data);
    }
}
