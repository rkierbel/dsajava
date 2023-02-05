package sorting;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    selectionSort(toSort);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void selectionSort(int[] toSort) {
    for (int unsortedPartitionIndex = toSort.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
      int indexLargest = 0;
      for (int i = 1; i <= unsortedPartitionIndex; i++)
        if (toSort[i] > toSort[indexLargest]) indexLargest = i;
      SortUtils.swap(toSort, indexLargest, unsortedPartitionIndex);
    }
  }
}
