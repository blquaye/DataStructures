package LinkedList;

public class LinkedList2 {

    public Node head;
    public Node tail;
    public int size;

    public class Node{
        public int value;
        public Node next;
    }
    public Node createSinglyLinkedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail =node;
        size =1;
        return head;
    }
    public void insertSinglyLinkedList(int location, int nodeValue){
        Node node = new Node();
        node.value =nodeValue;
        if(head == null){
            createSinglyLinkedList(nodeValue);
        }else if(location == 0){
            node.next =  head;
            head = node;
        }else if(location >=size){
            tail.next = node.next;
            node.next =null;
            tail =node;
        }else{
            Node temp = head;
            int index =0;
            while (index < location -1){
                temp = temp.next;
                index++;
            }
            Node newNode = temp.next;
            temp.next =  node;
            node.next = newNode;
        }
        size++;
    }
    public void traversalSinglyLinkedList(){
        Node tempNode = head;
        if(head == null){
            System.out.printf("SinglyLinked List does not exist.");
        }else{
            for (int i = 0; i <size; i++) {
                System.out.print(tempNode.value);
                if(i !=size-1){
                    System.out.print("-->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }
    public void deleteNode(int location){
        if(head == null){
            System.out.println("No Nodes to delete.");
        }else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        }else if(location >=size){
            Node tempNode  = head;
            for (int i = 0; i < size-1; i++) {
                tempNode = tempNode.next;
            }
            if(tempNode == head){
                head =null;
                size--;
                return;
            }
            tempNode.next = null;
            tail =tempNode;
            size--;
        }else{
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        ll.createSinglyLinkedList(5);
        ll.insertSinglyLinkedList(0, 1);
        ll.insertSinglyLinkedList(1, 3);
        ll.insertSinglyLinkedList(2, 7);
        ll.traversalSinglyLinkedList();
        ll.deleteNode(3);
        ll.traversalSinglyLinkedList();
    }
}
