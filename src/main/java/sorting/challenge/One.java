package sorting.challenge;

public class One {

  static void mergeSort(int[] arr, int start, int end) {
    if (end - start == 1) return;
    int mid = (end + start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid, end);
    merge(arr, start, mid, end);
  }

  private static void merge(int[] arr, int start, int mid, int end) {
    if (arr[mid - 1] > arr[mid]) return;
    int[] tmp = new int[end - start];
    int k = 0;
    int i = start;
    for (int j = mid; i < mid && j < end; k++) {
      if (arr[i] > arr[j]) {
        tmp[k] = arr[i];
        i++;
      }
      else if (arr[i] <= arr[j]) {
        tmp[k] = arr[j];
        j++;
      }
    }
    System.arraycopy(arr, i, arr, start + k, mid - i);
    System.arraycopy(tmp, 0, arr, start, k);
  }
}
