package LinkedList;

import java.util.HashMap;

public class LinkedList {

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
        node.value =  nodeValue;
        node.next =  null;
        head = node;
        tail =  node;
        size = 1;
        return head;
    }
    public void insertSinglyLinkedList(int nodeValue,  int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head ==  null){
            createSinglyLinkedList(nodeValue);
        }else  if (location == 0){
            node.next = head;
            head = node;
        }else if(location >= size){
            tail.next =  node;
            node.next =  null;
            tail = node;
        }else{
            Node tempNode = head;
            int index = 0;
            while (index < location -1){
                tempNode = tempNode.next;
                index++;
            }
            Node newNode = tempNode.next;
            tempNode.next = node;
            node.next = newNode;
        }
        size++;
    }
    public void TraversalSll(){
        Node tempNode = head;
        if(head == null){
            System.out.printf("SinglyLinked List does not exist.");
        }else{
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if(i >=size-1){
                    System.out.printf("-->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }
    public void deleteSll(){
        head =null;
        tail =null;
    }
    public void deleteNode(int location){
        if(head == null) {
            System.out.printf("No values in the linked list.");
        }else if(location ==0){
            head = head.next;
            size--;
            if(size ==0 ){
                tail = null;
            }
        }else if(location >=size){
//            Find node located before last Node
            Node tempNode = head;
//            Find node located before the last node
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
//            If we have one element;
            if(tempNode == head){
                head = null;
                size--;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }else{
//            Any Given location
            Node tempNode =head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
//            Reference node after the location we want to delete
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
    public void removeDuplicate(LinkedList ll){

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createSinglyLinkedList(5);
        ll.insertSinglyLinkedList(1,0);
        ll.insertSinglyLinkedList(33,1);
        ll.insertSinglyLinkedList(10,2);
       ll.TraversalSll();
    }
}
