//package Trees;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BinaryTree extends BinaryNode {
//    public BinaryNode root;
//
//    public BinaryTree() {
//        this.root = null;
//    }
////    Traversal Methods
//    /**
//     * preOrder Traversal Method
//     * NLR
//     */
//    public void preOrder(BinaryNode node){
//        if (node == null){
//            return;
//        }
//        System.out.print(node.value + " ");
//        preOrder(node.left);
//        preOrder(node.right);
//    }
//    /**
//     * inOrder Traversal
//     * LNR
//     */
//    public void inOrder(BinaryNode node){
//        if (node == null){
//            return;
//        }
//        inOrder(node.left);
//        System.out.println(node.value + " ");
//        inOrder(node.right);
//    }
//    /**
//     * postOrder Traversal
//     * LRN
//     */
//    public void postOrder(BinaryNode node){
//        if(node == null){
//            return;
//        }
//        postOrder(node.left);
//        postOrder(node.right);
//        System.out.println(node.value + " ");
//    }
//    /**
//     * Level Order Traversal
//     * starting from the root we visit each level and progress from
//     * the left subtree to the right subtree
//     */
//    public void levelOrder(){
//        Queue<BinaryNode> queue =  new LinkedList<BinaryNode>();
//        queue.add(root);
//        while (!queue.isEmpty()){
////            Takes the first element in the queue and removes it
////            BinaryTree always starts at index 1 instead of 0 for easier calculation
//            BinaryNode currentNode = queue.remove();
//            System.out.println(currentNode.value + ' ');
//            if (currentNode.left != null){
//                queue.add(currentNode.left);
//            }
//            if (currentNode.right != null){
//                queue.add(currentNode.right);
//            }
//        }
//    }
////    Search Method
////    Parameter refers to the data used in BinaryNode;
//    public void search(String value){
//        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            BinaryNode currentNode = queue.remove();
//            if(currentNode.value ==  value) {
//                System.out.printf("Value: " + value + " found in the tree.");
//                return;
//            }else{
//                if(currentNode.left != null){
//                    queue.add(currentNode.left);
//                }
//                if (currentNode.right != null){
//                    queue.add(currentNode.right);
//                }
//            }
//        }
//        System.out.printf("Value is not found.");
//    }
////    Insertion Method
//    public void insert(String value){
//        BinaryNode newNode = new BinaryNode();
//        newNode.value = value;
//        if(root == null){
//            root = newNode;
//            System.out.println("Inserted new node at the root.");
//            return;
//        }
////        If not in the root insert anywhere
//        Queue<BinaryNode> queue =  new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            BinaryNode currentNode = queue.remove();
//            if(currentNode.left == null){
//                currentNode.left =newNode;
//                System.out.println("Successfully Inserted: "  + value);
//                break;
//            }else if (currentNode.right ==null){
//                currentNode.right = newNode;
//                System.out.println("Successfully inserted:" +value);
//                break;
//            }else{
//                queue.add(currentNode.left);
//                queue.add(currentNode.right);
//            }
//        }
//    }
//    /**
//     * Deletion
//     */
////    Get Deepest tree Node
//    public BinaryNode getDeepestNode(){
//        Queue<BinaryNode> queue =  new LinkedList<>();
//        queue.add(root);
//        BinaryNode currentNode = null;
//        while (!queue.isEmpty()){
//            currentNode = queue.remove();
//            if(currentNode.left != null){
//                queue.add(currentNode.left);
//            }
//            if(currentNode.right != null){
//                queue.add(currentNode.right);
//            }
//        }
//        return currentNode;
//    }
////    Delete deepest node.
//    public void deleteDeepestNode(){
//        Queue<BinaryNode>  queue = new LinkedList<>();
//        queue.add(root);
//        BinaryNode previousNode,currentNode = null;
//        while (!queue.isEmpty()){
//            previousNode = currentNode;
//            currentNode = queue.remove();
//            if(currentNode.left == null){
////                dequeue
//                previousNode.right = null;
//                return;
//            }else if(currentNode.right == null){
//                currentNode.left  = null;
//                return;
//            }
//            queue.add(currentNode.left);
//            queue.add(currentNode.right);
//        }
//    }
////    Delete a given Node
//    public void deleteNode(String value){
//        Queue<BinaryNode>  queue =  new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            BinaryNode currentNode =  queue.remove();
//            if (currentNode.value == value){
//                currentNode.value = getDeepestNode().value;
//                deleteDeepestNode();
//                System.out.println("The node is deleted.");
//                return;
//            }else{
//                if(currentNode.left !=null){
//                    queue.add(currentNode.left);
//                }
//                if(currentNode.right !=null){
//                    queue.add(currentNode.right);
//                }
//            }
//        }
//        System.out.println("Node does not exist in Binary Tree.");
//    }
//    public void deleteBinaryTree(){
//        root = null;
//        System.out.println("Binary Tree deleted.");
//    }
//
//    public static void main(String[] args) {
//        BinaryTree bt = new BinaryTree();
//        bt.insert("N1");
//        bt.insert("N2");
//        bt.insert("N3");
//        bt.insert("N4");
//        bt.insert("N5");
//        bt.insert("N6");
//        bt.levelOrder();
//        System.out.println("");
//        bt.deleteNode("N3");
//        bt.levelOrder();
//        bt.deleteBinaryTree();
//        bt.levelOrder();
//    }
//}
