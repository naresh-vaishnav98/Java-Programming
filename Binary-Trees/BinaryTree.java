import java.util.*;

public class BinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root){

            if(root == null){
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root == null){
                // System.out.print("-1 ");
                return;
            }
            
            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null){
                // System.out.print("-1 ");
                return;
            }
            
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+ " ");
            
        }

        public static void levelOrder(Node root){
            if(root == null){
                // System.out.print("-1 ");
                return;
            }
            
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data);
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                    
                }
            }
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh,rh) + 1;
        }

        public static int numOfNodes(Node root){
            // int count = 0;
            if(root == null){
                return 0;
            }
            // count++;
            int Lcount = numOfNodes(root.left);
            int Rcount = numOfNodes(root.right);
            int count = Lcount + Rcount + 1;

            return count;

        }
    }

    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinTree b1 = new BinTree();
        Node root = b1.buildTree(nodes);
        System.out.println(root.data);

        System.out.print("Pre-Order : ");
        b1.preOrder(root);
        System.out.println();
        System.out.print("In-Order : ");
        b1.inOrder(root);
        System.out.println();
        System.out.print("Post-Order : ");
        b1.postOrder(root);
        System.out.println();
        System.out.println("Level-Order : ");
        b1.levelOrder(root);

        System.out.println();
        System.out.print("Height of Tree : ");
        System.out.println(b1.height(root));

        System.out.println();
        System.out.print("Number of Nodes : ");
        System.out.println(b1.numOfNodes(root));

    }
}