package sorting;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    insertionSort(toSort);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void insertionSort(int[] toSort) {
    for (int unsortedPartitionIndex = 1; unsortedPartitionIndex < toSort.length; unsortedPartitionIndex++) {
      int newElem = toSort[unsortedPartitionIndex];
      int i;
      for (i = unsortedPartitionIndex; i > 0 && toSort[i - 1] > newElem; i--) {
        toSort[i] = toSort[i - 1];
        System.out.println(Arrays.toString(toSort));
      }
      toSort[i] = newElem;
      System.out.println(Arrays.toString(toSort));
    }
  }
}
