package sorting;

import java.util.Arrays;

public class CountingSort {

  public static void main(String[] args) {
    int[] toSort = new int[]{2, 3, 5, 6, 10, 8, 2, 4, 9, 4};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    countingSort(toSort, 10);
    System.out.println("SORTED ! " + Arrays.toString(toSort));

    int[] toSort2 = new int[]{2, 3, 5, 6, 10, 8, 2, 4, 9, 4};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    countingSort(toSort2, Arrays.stream(toSort).min().getAsInt(), Arrays.stream(toSort).max().getAsInt());
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void countingSort(int[] toSort, int range) {
    int[] counting = new int[range];
    for (int i = 0; i < range; i++) {
      counting[toSort[i] - 1] += 1;
    }
    for (int i = 0, j = 0; i < range; i++) {
      while (counting[i] > 0) {
        toSort[j] = i + 1;
        j++;
        counting[i]--;
      }
    }
  }

  private static void countingSort(int[] toSort, int min, int max) {
    int[] counting = new int[(max - min) + 1]; //lage enough to count each possible value
    for (int i : toSort) {
      counting[i - min]++; //translate values in range to indexes from 0 to (max - min)
    }
    int j = 0;
    for (int i = min; i <= max; i++) { //write values of i directly into toSort]
      while (counting[i - min] > 0) {
        toSort[j++] = i;
        counting[i - min]--;
      }
    }
  }
}
