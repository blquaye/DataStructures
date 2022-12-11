package Queue;

import LinkedList.LinkedList;

public class LinkedQueue {
    LinkedList list;

    public LinkedQueue() {
        this.list = new LinkedList();
    }
    /**
     * is Empty method.
     */
    public boolean isEmpty(){
        if(list.head == null){
            return true;
        }else{
            return false;
        }
    }
    /**
     * enQueue method
     */
    public void enQueue(int value){
         list.insertSinglyLinkedList(value, list.size);
        System.out.println("Successfully inserted: "  + value);
    }
    /**
     * deQueue method
     */
    public int deQueue(){
        int result = 0;
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            result = list.head.value;
            list.deleteNode(0);
            return result;
        }
    }
    /**
     * peek method
     */
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
             return list.head.value;
        }
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(12);
        queue.enQueue(55);
        int test = queue.deQueue();
        int test2 = queue.deQueue();
        int test3 = queue.peek();
        System.out.println(test3);
    }
}
