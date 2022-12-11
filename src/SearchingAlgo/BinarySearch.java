package SearchingAlgo;

import java.util.Arrays;

public class BinarySearch {

    public int binarySearch(int [] array, int target){
        int start =0;
        int end = array.length-1;
        int middle = (start + end)/2;
        System.out.println(start + " " +middle+ " " + end);
        while (array[middle] !=target){
            if(target < array[middle]){
                end = middle-1;
            }else{
                start = middle +1;
            }
            middle =  (start + end)/2;
            System.out.println(start + " " +middle+ " " + end);
        }
        if (array[middle] == target){
            System.out.println("Element found at the index: " + middle);
            return middle;
        }else {
            System.out.println("Value is not found in the array.");
            return -1;
        }
    }

    public static void main(String[] args) {
        int arry [] = {1,2,3,4,5,6};
        int target = 3;
        BinarySearch bs = new BinarySearch();
        bs.binarySearch(arry,target);
    }
}
