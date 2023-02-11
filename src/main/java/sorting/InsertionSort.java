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
      insert(toSort, unsortedPartitionIndex);
    }
  }

  public static void insert(int[] arr, int unsortedPartitionIdx) {
    int newElem = arr[unsortedPartitionIdx];
    int i;
    for (i = unsortedPartitionIdx; i > 0 && arr[i - 1] > newElem; i--) {
      arr[i] = arr[i - 1];
    }
    arr[i] = newElem;
  }
}
