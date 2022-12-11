package SearchingAlgo;

public class LinearSearch {
    public int linearSearch(int []array, int target){
        for (int i = 0; i < array.length; i++) {
            if(array[i] ==  target){
                System.out.println("Value of: " + target + " was found at index: " + i);
                return i;
            }
        }
        System.out.println("Value is not in the array.");
        return -1;
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,7,9};
        int target = 4;
        LinearSearch ls = new LinearSearch();
        ls.linearSearch(array,target);

    }
}
