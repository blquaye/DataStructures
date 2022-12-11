package LinkedList;

import java.util.LinkedList;

public class DeleteNode extends Node{
    public Node head;
    public Node tail;
    public int size;

    /**
     * Deletes a node from the linked list.
     * @param location
     */
    public void deleteNode(int location){
        if(head == null){
            System.out.println("No values to delete in Singly linkedList");
        } else if (location ==0) {
            head = head.next;
            size--;
            if(size ==0){
                tail = null;
            }
        }else if(location <=size){
            Node temp = head;
            for (int i = 0; i < size-1; i++) {
                temp = temp.next;
            }
            if(temp == head){
                head =null;
                size--;
            }
            temp.next = null;
            tail = temp;
            size--;
        }else{
            Node temp = head;
            for (int i = 0; i <size; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public static void main(String[] args) {

    }
}
