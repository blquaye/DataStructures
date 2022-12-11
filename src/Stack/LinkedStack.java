package Stack;

import LinkedList.LinkedList;

public class LinkedStack {
    LinkedList linkedList;

    public LinkedStack() {
        this.linkedList = new LinkedList();
    }
//    isEmpty Method
    public boolean isEmpty(){
        if (linkedList.head ==  null){
            return true;
        }else{
            return false;
        }
    }
    public void push(int value){
        linkedList.insertSinglyLinkedList(value,0);
        System.out.println("Successfully inserted: " + value);
    }
    public int pop(){
        int result = 0;
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        }else{
            result = linkedList.head.value;
            linkedList.deleteNode(0);
            return result;
        }
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
        }else{
            System.out.println(linkedList.head.value);
        }
    }
    public void deleteLinkedStack(){
        linkedList.head = null;
        linkedList.tail =  null;
        System.out.println("Stack is successfully deleted.");
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int test2 = stack.pop();
        boolean test = stack.isEmpty();
        stack.peek();
        System.out.println(test2);
    }
}
