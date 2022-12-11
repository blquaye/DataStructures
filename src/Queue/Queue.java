package Queue;

/**
 * Array implementation
 */
public class Queue {
    int [] queueArray;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public Queue(int size) {
        this.queueArray =  new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue =-1;
        System.out.println("Queue is successfully created.");
    }
//    IsEmpty method
    public boolean isfull(){
        if (topOfQueue == queueArray.length-1){
            return true;
        }else{
            return false;
        }
    }
//    isFull
    public boolean isEmpty(){
        if ( beginningOfQueue ==-1 || beginningOfQueue == queueArray.length){
            return true;
        }else{
            return false;
        }
    }
//enqueue (insertion)
    public void enQueue(int value){
        if (isfull()){
            System.out.println("Queue is Full");
        }else if (isEmpty()){
            beginningOfQueue  =0;
            topOfQueue++;
            queueArray[topOfQueue] = value;
            System.out.println("Successfully inserted: " + value);
        }else{
            topOfQueue++;
            queueArray[topOfQueue] = value;
            System.out.println("Successfully inserted: " + value);
        }
    }
//    dequeue deletion Method
    public int deQueue(){

        if (isEmpty()){
            System.out.println("Queue is Empty.");
            return -1;
        }else{
           int result =  queueArray[beginningOfQueue];
           beginningOfQueue++;
           if(beginningOfQueue > topOfQueue -1){
               beginningOfQueue = topOfQueue = -1;
           }
           return result;
        }
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }else{
            return beginningOfQueue;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enQueue(1);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(11);
       int test2 = queue.deQueue();
       int test3 = queue.deQueue();
        System.out.println(test3);
    }
}
