package LinkedList;

import Trees.BinaryNode;

import java.util.HashMap;

public class LinkedListTest2 {

    public Node head;
    public Node tail;
    public int size;

    public class Node{
        public double value;
        public Node next;
    }

    public Node createSLL(double value){
        head = new Node();
        Node node = new Node();
        node.value = value;
        node.next =  null;
        head = node;
        tail = node;
        size= 1;
        return head;
    }
    public void insertSLL(int location, double value){
        Node node = new Node();
        node.value = value;
        if(head ==  null){
            createSLL(value);
            /**
             * insert value at the beginning of singly linked list.
             */
        }else if(location == 0){
            head.next = node;
            node.next = head;
            head = node;
            /**
             * insert Singly Linked list at the end
             */
        }else if(location >= size){
            tail.next = node;
            node.next = null;
            tail = node;
            /**
             * insert anywhere in the Singly linkedlist
             */
        }else{
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode =  tempNode.next;
                index++;
            }
            Node newNode = tempNode.next;
            tempNode.next = node;
            node.next = newNode;
        }
        size++;
    }
    public void deleteSll(){
        head = null;
        tail =  null;
        System.out.println("Singly Linkedlist is deleted.");
    }
    public void traversalSLL(){
        if(head == null){
            System.out.println("No node values to traverse.");
        }
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if(i<=size-1){
                System.out.print("-->");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }
    public void deleteSinglyll(int location){
        Node node = new Node();
        if(head == null){

        }else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
            /** delete singly at the end of the linked list*/
        }else if(location >=  size){
           Node tempNode = head;
            for (int i = 0; i < size-1; i++) {
                tempNode =tempNode.next;
            }
            if(tempNode == head){
                head = null;
                size--;
            }
            tail.next = tempNode;
            tempNode.next = null;
            tail = tempNode;
            size--;
            /**
             * if we need to delete at the end
             */
        }else{
            Node tempNode = head;
            for (int i = 0; i < location -1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        LinkedListTest2 ll =  new LinkedListTest2();
        ll.createSLL(3.0);
        ll.insertSLL(0,2.0);
        ll.insertSLL(1,7.0);
        ll.insertSLL(2,4.4);
        ll.deleteSinglyll(1);
        System.out.println(ll.head.next.next.next.value);
        ll.traversalSLL();
    }
}
