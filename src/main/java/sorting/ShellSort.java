package sorting;

import java.util.Arrays;

public class ShellSort {

  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    shellSort(toSort);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
    int[] toSort2 = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    shellSort2(toSort2);
    System.out.println("SORTED ! " + Arrays.toString(toSort2));
  }

  private static void shellSort(int[] toSort) {
    int gap = toSort.length / 2;
    while (gap > 0) {
      for (int i = gap; i < toSort.length; i++) {
        int newElem = toSort[i];
        int j = i;
        while (j >= 0 && newElem < toSort[Math.max(j - gap, 0)]) {
          toSort[j] = toSort[Math.max(j - gap, 0)];
          j -= gap;
        }
        toSort[Math.max(j, 0)] = newElem;
      }
      gap /= 2;
    }
  }

  private static void shellSort2(int[] toSort) {
    for (int gap = toSort.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < toSort.length; i++) {
        int newElem = toSort[i];
        int j;
        for (j = i; j >= gap && newElem < toSort[j - gap]; j -= gap)
          toSort[j] = toSort[j - gap];
        toSort[j] = newElem;
      }
    }
  }
}
