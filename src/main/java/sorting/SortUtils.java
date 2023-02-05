package sorting;

public class SortUtils {

  static void swap(int[] arr, int toSwap, int toSwapWith) {
    int temp = arr[toSwap];
    arr[toSwap] = arr[toSwapWith];
    arr[toSwapWith] = temp;
  }
}
