package LinkedList;

public class DoublyLinked {

    public Node head;
    public Node tail;
    public int size;



    public class Node{
        public Node next;
        public Node prev;
        public int value;
    }

    public Node createDoublyLinkedlist(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        node.prev =null;
        head =node;
        tail = node;
        size =1;
        return head;
    }
    public void insertDoublyLinked(int nodeValue, int location){
        Node newNode = new Node();
        newNode.value = nodeValue;
        if(head == null){
            createDoublyLinkedlist(nodeValue);
        }else if(location ==0){
            /**
             * New Node. prev must always point to null in
             * beginning of insertion.
             */
            newNode.prev =null;
            newNode.next =head;
            /**
             * Backward link to current first node
             */
            head.prev = newNode;
            head = newNode;
        }else if(location >=size){
            /**
             * newNode.next always points to null
             */
            newNode.next = null;
            /**
             * backward link to newly created node and currentNode
             */
            newNode.prev = tail;
            tail.next = newNode;
            tail  = newNode;
        }else{
            Node tempNode =head;
            int index =0;
            while (index < location -1){
                tempNode =tempNode.next;
                index++;
            }
            /**
             * backward link between newly created node and tempNode (currentnode)
             */
            newNode.prev =  tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev= newNode;
        }
        size++;
    }
    public void traverseDoublyLinked(){
        if (head==null){
            System.out.println("No Values to Traverse");
        }else{
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                /**
                 * if we haven't reached the last node.
                 */
                if(i !=size-1){
                    System.out.print("-->");
                }
                /**
                 * updates to next reference.
                 */
                tempNode =tempNode.next;
            }
        }
        System.out.println("\n");

    }
    public void reverseTraversalDL(){
        if(head!=null){
            Node tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if(i !=size-1){
                    System.out.print("->");
                }
                tempNode =tempNode.prev;
            }
            System.out.println("\n");
        }else{
            System.out.println("No Values to Reverse. Doubly does not exist.");
        }
    }
    public boolean searchDoublyLinked(int nodeValue){
        /**
         * similar to traverse except you need a conditional
         * statement assessing whether the value is there or not
         * i.e if (TempNode == nodeValue)
         */
        if (head!=null){
            Node tempNode = head;
            for (int i = 0; i <size; i++) {
                if(tempNode.value == nodeValue){
                    System.out.print(nodeValue + " found at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found.");
        return false;
    }
    public void deleteNode(int location){
        if(head == null){
            System.out.println("No values to delete.");

        }else if(location == 0){
            /**
             * only have one element
             */
            if (size ==1){
                head =null;
                tail = null;
                size--;
            }else{
                head =head.next;
                head.prev = null;
                size--;
            }
        } else if (location >=size) {
            Node tempNode = tail.prev;
            if (size==1){
                head =null;
                tail = null;
                size--;
            }else{
                tempNode.next =null;
                tail =tempNode;
                size--;
            }
        }else{
            Node tempNode =head;
            for (int i = 0; i < location - 1; i++) {
                tempNode =tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public static void main(String[] args) {
        DoublyLinked dl = new DoublyLinked();
        dl.createDoublyLinkedlist(5);
        dl.insertDoublyLinked(1,0);
        dl.insertDoublyLinked(3,1);
        dl.insertDoublyLinked(4,2);
        dl.insertDoublyLinked(9,7);
        dl.deleteNode(1);
        dl.traverseDoublyLinked();
        dl.reverseTraversalDL();


    }
}
