package Stack;

/**
 * Array Implementation
 */
public class Stack {
    int [] stackArray;
    int topOfStack;

//    Constructor for when we initialize the Stack

    public Stack(int size) {
        this.stackArray =  new int[size];
        this.topOfStack = -1;
        System.out.println("Stack is successfully created with size of: "  +size);
    }
//    Empty Method
    public boolean isEmpty(){
        if(topOfStack == -1){
            return true;
        }else{
            return false;
        }
    }
//    isFull
    public boolean isFull(){
        if(topOfStack == stackArray.length){
            return true;
        }else{
            return false;
        }
    }
//    push (insertion method)
    public void push(int value){
        if(isFull()){
            System.out.println("Stack is full.");
        }else{
            stackArray[topOfStack+1] = value;
            topOfStack++;
            System.out.println("Successfully inserted: " +  value);
        }
    }
//    pop (deletion) method
    public int pop(){

        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int topStack = stackArray[topOfStack];
            topOfStack--;
            return topStack;
        }
    }
    public void deleteStack(){
        topOfStack = -1;
        System.out.println("Succesfully deleted.");
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(13);
        stack.push(777);

        int test = stack.pop();
        int test2 = stack.pop();

        stack.deleteStack();

       boolean test3 = stack.isFull();
       int test4 = stack.pop();
        System.out.println(test3);
    }
}
