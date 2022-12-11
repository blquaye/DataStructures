package SortingAlgo;

public class BubbleSort {

  public  void bubbleSort(int arr[]) {
//      store length;
//      initial loop to intierative through each pair subtracting one gets you up to the last element
      for (int i = 0; i < arr.length; i++) {
          for (int j = 1; j < arr.length; j++) {
              if(arr[j] < arr[j-1]){
                  swap(arr,j,j-1);
              }
          }
      }
  }
  public void swap(int [] array, int index1, int index2){
      int temp = array[index1];
      array[index1] = array[index2];
      array[index2] =  temp;
  }

  public void printArray(int arr[]){
      int n = arr.length;
      for (int i = 0; i < n; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println();
  }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int arr [] = {10,5,30,15,50,5};
        bs.bubbleSort(arr);
        bs.printArray(arr);
    }
}
