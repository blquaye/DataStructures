package SortingAlgo;

public class SelectionSort {

    public void printArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public void selectionSort(int [] a){
        for (int i = 0; i < a.length; i++) {
            int minimumIndex = i;
            for (int j =i+1; j<a.length;j++){
                if(a[j]  <a[minimumIndex]){
                    minimumIndex = j;
                }
            }
            if(minimumIndex != i){
                int temp = a[i];
                a[i] = a[minimumIndex];
                a[minimumIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,3,6,9,4,2,1};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        ss.printArray(arr);
    }
}
