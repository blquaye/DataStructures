package SearchingAlgo;

public class BinarySearch2 {
   public int binarySearchImplementation(int [] array, int target){
       int start = 0;
       int end = array.length-1;
       int middle = (start + end)/2;
       System.out.println(start + " " + middle + " " +  end);
       while (array[middle] !=target){
           if(target<=array[middle]){
               end = middle - 1;
           }else{
               start =  middle + 1;
           }
           middle = (start + end )/2;
           System.out.println(start + " " + middle + " " +  end);
       }
       if(array[middle] == target){
           System.out.println("Value is found at index of: " +  middle);
           return middle;
       }else{
           System.out.println("Value is not in the array.");
           return -1;

       }
   }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        int target = 2;
        BinarySearch2 bs = new BinarySearch2();
        bs.binarySearchImplementation(array,target);
    }
}
