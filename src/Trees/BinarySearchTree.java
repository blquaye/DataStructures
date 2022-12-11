package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    /**
     * Common Operations
     *
     *Creation of BST
     * Insertion
     * Delete Node
     * Search
     * Traversal
     * DeleteBSt
     *
     */
    public BinaryNode root;

    public BinarySearchTree() {
        this.root =null;
    }

    public class BinaryNode{
        public int value;
        public int height;
        public BinaryNode left;
        public BinaryNode right;
    }

    private BinaryNode insertBST(BinaryNode currentNode, int value){
        if(currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
//            System.out.println("The value successfully inserted.");
            return newNode;
        }else if (value <= currentNode.value){
//            recursion
            currentNode.left = insertBST(currentNode.left,value);
            return currentNode;
        }else{
//            recursion
            currentNode.right = insertBST(currentNode.right,value);
            return currentNode;
        }
    }
//    insertion
    public void insert(int value){
    root = insertBST(root,value);
    }

//    Traversal
//    NLR
    public void preOrder(BinaryNode node){
        if (node == null){
            return;
        }
        System.out.print(node.value +  " ");
        preOrder(node.left);
        preOrder(node.right);
    }
//    inOrder LNR
    public void inOrder(BinaryNode node){
        if(root == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value  + " ");
        inOrder(node.right);
    }
//    PostOrder LRN
    public void postOrder(BinaryNode node){
        if(root == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
//    levelOrder
    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            System.out.println(currentNode.value + " ");
//            Include left child first because in Breadth first search we need to visit the left subtree first.
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right !=null){
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * Search method
     * @param
     */
    public BinaryNode search(BinaryNode node, int value){
        if(node ==  null){
            System.out.println("Value: "  + value + " is not in the Binary Search Tree");
            return null;
//            Node value with the value we're looking for. root
        }else if (node.value == value){
            System.out.println("Value: " + value + " found in BST");
            return node;
//            Traverse left subtree until value is found
        }else if(value <= node.value){
            return search(node.left,value);
//            Traverse right subtree until value is found
        }else{
            return search(node.right,value);
        }
    }

    /**
     * Minimum Node
     * @param root
     */
    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left ==  null){
            return root;
        }else{
//            Minimum found in left
            return minimumNode(root.left);
        }
    }

    /**
     * Node we are deleting
     * @param root
     */
    public BinaryNode deleteNode(BinaryNode root, int value){
        if(root == null){
            System.out.println("Value is not found in Binary Search");
            return null;
        }
//        Traverse left subtree
        if (value < root.value){
            root.left = deleteNode(root.left,value);
//        Traverse right subtree
        }else if(value > root.value){
            root.right = deleteNode(root.right,value);
        }else{
            if(root.left != null && root.right != null){
                BinaryNode tempNode = root;
//                find minimum element from right subtree
                BinaryNode minimumNodeRight = minimumNode(tempNode.right);
                root.value = minimumNodeRight.value;
                root.right = deleteNode(root.right,minimumNodeRight.value);
            }else if (root.left != null){
                root = root.left;
            }else if(root.right != null){
                root = root.right;
            }else{
                root = null;
            }
        }
        return root;
    }
    public void deleteBST(){
        root = null;
        System.out.println("Binary Search Tree deleted.");
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70); //root node;
        bst.insert(50);
        bst.insert(90);
        bst.insert(40);
        bst.insert(20);
        bst.insert(80);
        bst.insert(60);
        bst.insert(100);
        bst.search(bst.root, 90);
    }
}
