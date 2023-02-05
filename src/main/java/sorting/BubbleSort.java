package sorting;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    bubbleSort(toSort);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void bubbleSort(int[] toSort) {
    for (int unsortedPartitionIndex = toSort.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--)
      for (int i = 0; i < unsortedPartitionIndex; i++)
        if (toSort[i] > toSort[i + 1]) SortUtils.swap(toSort, i, i + 1);
  }
}
