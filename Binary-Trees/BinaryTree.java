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

        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int Lsum = sumOfNodes(root.left);
            int Rsum = sumOfNodes(root.right);
            int TotalSum = Lsum + Rsum + root.data;

            return TotalSum;
        }

        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int Ldiam = diameter(root.left);
            int Lheight = height(root.left);
            int Rdiam = diameter(root.right);
            int Rheight = height(root.right);
            int selfDiam = Lheight + Rheight + 1;

            return Math.max(selfDiam, Math.max(Ldiam, Rdiam));
        }

        static class info{
            int diam;
            int ht;

            info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static info diameterHeight(Node root){
            if(root == null){
                return new info(0,0);
            }
            
            info Linfo = diameterHeight(root.left);
            info Rinfo = diameterHeight(root.right);
            int diam = Math.max(Math.max(Linfo.diam, Rinfo.diam), Linfo.ht + Rinfo.ht + 1);
            int ht = Math.max(Linfo.ht, Rinfo.ht) + 1;

            return new info(diam, ht);
        }


        public static boolean isIdentical(Node node, Node subRoot){
            if(node == null && subRoot == null){
                return true;
            }else if(node == null || subRoot == null || node.data != subRoot.data){
                return false;
            }

            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }

            return true;
        }

        public static boolean isSubtree(Node root, Node subRoot){
            if(root == null){
                return false;
            }

            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }

            // boolean leftAns = isSubtree(root.left,subRoot);
            // boolean rightAns = isSubtree(root.right,subRoot);

            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }


        //Top View

        static class Pair{
            int hd;
            Node node;

            Pair(Node node, int hd){
                this.hd = hd;
                this.node = node;
            }
        }

        public static void topView(Node root){
            
            if(root == null){
                return;
            }

            Queue<Pair> que = new LinkedList<>();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            que.add(new Pair(root,0));
            
            while(!que.isEmpty()){
                Pair curr = que.remove();
                Node node = curr.node;
                int hd = curr.hd;

                if(!map.containsKey(hd)){
                    map.put(hd, node.data);
                }

                if(node.left != null){
                    que.add(new Pair(node.left, hd-1));
                }

                if(node.right != null){
                    que.add(new Pair(node.right, hd+1));
                }
            }

            for(int top : map.values()){
                System.out.print(top + " ");
            }
        }

        public static void kthLevel(Node root, int level, int k){
            if(root == null){
                return;
            }

            if(level == k){
                System.out.print(root.data + " ");
                return;
            }

            kthLevel(root.left, level + 1, k);
            kthLevel(root.right, level + 1, k);
        }

        //Lowest Common Ancestor

        public static Node LCA(Node root, Node p, Node q){
            if(root == null){
                return null;
            }

            if(root == p || root == q){
                return root;
            }

            Node left = LCA(root.left, p, q);
            Node right = LCA(root.right, p, q);

            if(left != null && right != null){
                return root;
            }

            if(left != null){
                return left;
            }else{
                return right;
            }
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

        System.out.println();
        System.out.print("Sum of Nodes : ");
        System.out.println(b1.sumOfNodes(root));

        System.out.println();
        System.out.print("Diameter of Tree : ");
        System.out.println(b1.diameter(root));

        System.out.println();
        System.out.print("Diameter and Height of Tree : ");
        System.out.println(b1.diameterHeight(root).diam +", " + b1.diameterHeight(root).ht);

        Node newNode = new Node(2);
        newNode.left = new Node(4);
        newNode.right = new Node(5);

        System.out.println();
        System.out.print("Subtree Or Not : ");
        System.out.println(b1.isSubtree(root, newNode));

        System.out.println();
        System.out.print("Top-View Node : ");
        b1.topView(root);

        System.out.println();
        System.out.print("Kth Level Node : ");
        // System.out.println(b1.kthLevel(root, 1, 3));
        b1.kthLevel(root, 1, 3);

        System.out.println();
        System.out.print("Lowest Common Ancestor : ");
        System.out.println(b1.LCA(root, root.left.left, root.left.right).data);

    }
}