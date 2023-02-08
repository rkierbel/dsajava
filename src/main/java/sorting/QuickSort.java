package sorting;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    quick(toSort, 0, toSort.length);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void quick(int[] arr, int start, int end) {
    if (end - start < 2) return;
    int pivotIndex = partition(arr, start, end); //returns sorted position of pivot in sorted array
    quick(arr, start, pivotIndex); //sort all elements smaller than the pivot / left partition
    quick(arr, pivotIndex + 1, end); //sort all elements bigger than the pivot / right partition
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[start]; //start index of array or sub-array
    int i = start;
    int j = end;
    while (i < j) {
      //just loop and decrease j while elements are at their rightful position compared to the pivot's value
      while (i < j && arr[--j] > pivot);
      if (i < j) {
        arr[i] = arr[j]; //arr[j] is the first element that is less than the pivot and needs to be put left of the pivot
      }
      //just loop and increase i -> elements are at their rightful position compared to the pivot's value
      while (i < j && arr[++i] <= pivot);
      if (i < j) {
        arr[j] = arr[i];
      }
    }
    arr[i] = pivot;
    return i;
  }

  static class QuickSortOther {
    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    static int partition(int[] arr, int low, int high) {

      // pivot
      int pivot = arr[high];

      // Index of smaller element and
      // indicates the right position
      // of pivot found so far
      int i = (low - 1);

      for (int j = low; j <= high - 1; j++) {

        // If current element is smaller
        // than the pivot
        if (arr[j] < pivot) {

          // Increment index of
          // smaller element
          i++;
          SortUtils.swap(arr, i, j);
        }
      }
      SortUtils.swap(arr, i + 1, high);
      return (i + 1);
    }

    /* The method that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
      if (low < high) {

        // pi is partitioning index, arr[p]
        // is now at right place
        int pi = partition(arr, low, high);

        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
      }
    }

    // Function to print an array
    static void printArray(int[] arr, int size) {
      for (int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");

      System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
      int[] arr = { 10, 7, 8, 9, 1, 5 };
      int n = arr.length;

      quickSort(arr, 0, n - 1);
      System.out.println("Sorted array: ");
      printArray(arr, n);
    }
  }
}
