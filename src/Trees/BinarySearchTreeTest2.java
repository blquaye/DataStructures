package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeTest2 {

    public BinaryNode root;

    public class BinaryNode{
        public int value;
        public BinaryNode left;
        public BinaryNode right;
        public int height;

    }

    public BinarySearchTreeTest2() {
        this.root = null;
    }

    /**
     * Traversal Methods
     * Depth for search
     * preOrder NLR
     * inOrder LNR
     * postOrder LRN
     */
    public void preOrder(BinaryNode node){

        if(root ==  null){
            System.out.println("Error no node values to traverse");
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(BinaryNode node){
        if(root == null){
            System.out.println("Error no node values to traverse.");
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
    public void postOrderTraversal(BinaryNode node){
        if(root == null){
            System.out.println("Error no values found.");
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value + " ");
    }
    /**
     * Breadth for search
     */
    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }
    public BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.println("Value: " + value + " not found in Binary search tree." );
            return null;
            /**
             * this implies that node value is a root value so search to see in the binary search tree.
             */
        }else if(node.value == value){
            System.out.println("Value: " + value + " found in Binary search tree.");
            /**
             * this implies that the value is located at the left subtree of the binary search tree.
             */
            return node;
        }else if(value <= node.value){
            return search(node.left,value);
            /**
             * else it will be in the right subtree
             */
        }else{
            return search(node.right,value);
        }
    }

    /**
     * this BinaryNode points to a specific node i.e the  currentNode and inserts Value
     * @param currentNode
     * @param value
     * @return
     */
    public BinaryNode insertBST(BinaryNode currentNode, int value){
        if(currentNode == null){
            /**
             * this simply implies that since our nodes are null
             * we need to create a node to insert a value into the tree.
             */
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("Successfully inserted: "  + value);
            return newNode;
            /**
             * this implies if value is less than our currentNode we need to insert value to
             * the left of the Binary tree
             */
        }else if(value <= currentNode.value){
            currentNode.left =  insertBST(currentNode.left,value);
            return currentNode;
            /**
             * instead of left now insert to the right of Binary Search tree.
             */
        }else{
            currentNode.right = insertBST(currentNode.right,value);
            return currentNode;
        }
    }
    public void insert(int value){
        root = insertBST(root,value);
    }

    public static void main(String[] args) {
        BinarySearchTreeTest2 bst = new BinarySearchTreeTest2();
        bst.insert(70);
        bst.insert(20);
        bst.insert(30);
        bst.insert(90);
        bst.insert(100);
        bst.insert(10);
        bst.insert(40);
        bst.search(bst.root,80);


    }

}
