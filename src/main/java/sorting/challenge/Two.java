package sorting.challenge;

import sorting.InsertionSort;

public class Two {

  public static void recursiveInsertionSort(int[] arr, int unsortedPartitionIdx) {
    if (unsortedPartitionIdx == arr.length) return;
    InsertionSort.insert(arr, unsortedPartitionIdx);
    recursiveInsertionSort(arr, ++unsortedPartitionIdx);
  }

  public static void otherRecursiveInsertionSort(int[] arr, int items) {
    if (items < 2) return;
    otherRecursiveInsertionSort(arr, --items);
    int newElem = arr[items - 1];
    int i;
    for (i = items - 1; i > 0 && arr[i - 1] > newElem; i--) {
      arr[i] = arr[i - 1];
    }
    arr[i] = newElem;
  }
}
