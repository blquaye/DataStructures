package Stack;

public class StackArrayTest2 {

    public double [] stack;
    public double topOfStack;

    public StackArrayTest2(int size) {
        this.stack = new double[size];
        this.topOfStack =-1.0;
        System.out.println("Stack is successfully created.");
    }
    /**
     * Empty and Full methods
     */
    public boolean isEmpty(){
        if(topOfStack ==-1.0){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFull(){
        if (topOfStack == stack.length-1){
            return true;
        }else {
            return false;
        }
    }
    /**
     * push and pop methods
     */
    public void push(double value){
        if(isFull()){
            System.out.println("Stack is full cannot push values in.");
        }else{
            stack[(int) topOfStack+1] = value;
            topOfStack++;
            System.out.println("Successfully inserted: " +  value);
        }
    }
    public double pop(){
        if(isEmpty()){
            System.out.println("No values to pop in the stack.");
            return -1;
        }
        double topStack = stack[(int)topOfStack];
        topOfStack--;
        return topStack;
    }
    public double peek(){
        if(isEmpty()){
            System.out.println("No values to peek");
            return -1;
        }else{
            return topOfStack;
        }
    }
    public void deleteSLL(){
        stack = null;
        System.out.println("Successfully deleted.");
    }

    public static void main(String[] args) {
        StackArrayTest2 stack = new StackArrayTest2(5);
        stack.push(2.0);
        stack.push(20.2);
        stack.push(4.44);
        stack.push(77.7);
        stack.push(3.13);
       double test3 = stack.pop();
       double test4 = stack.pop();
        boolean test1 = stack.isFull();
        boolean test2= stack.isEmpty();
        System.out.println(test4);
    }
}
