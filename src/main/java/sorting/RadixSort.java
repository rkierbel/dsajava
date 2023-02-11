package sorting;

import java.util.Arrays;

public class RadixSort {
  public static void main(String[] args) {
    int[] toSort = new int[]{8792, 1330, 4725, 1594, 4586, 5729};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    radixSort(toSort, 10, 4);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void radixSort(int[] toSort, int radix, int width) {
    int elems = toSort.length;
    for (int pos = 1; pos <= width; pos++) {
      int[] digits = new int[elems];
      for (int i = 0; i < elems; i++) digits[i] = getDigitWithDiv(pos, toSort[i], radix);
      int[] countArr = new int[radix];
      for (int i : digits) {
        countArr[i]++;
      }
      for (int i = 1; i < countArr.length; i++) {
        countArr[i] += countArr[i - 1];
      }
      int[] tmp = new int[elems];
      for (int k = elems - 1; k >= 0; k--) {
        int valInCount = --countArr[digits[k]];
        tmp[valInCount] = toSort[k];
      }
      System.arraycopy(tmp, 0, toSort, 0, tmp.length);
    }
  }

  private static void rdxSort(int[] toSort, int radix, int width) {
    for (int i = 0; i < width; i++) {
      radixSingleSort(toSort, i, radix);
    }
  }

  private static void radixSingleSort(int[] toSort, int pos, int radix) {
    int elems = toSort.length;
    int[] countArr = new int[radix];
    for (int val : toSort) {
      countArr[getDigit(pos, val, radix)]++; //conventional count array
    }
    for (int i = 1; i < countArr.length; i++) {
      countArr[i] += countArr[i - 1];
    }
    int[] tmp = new int[elems];
    for (int tmpIdx = elems - 1; tmpIdx >= 0; tmpIdx--) {
      tmp[--countArr[getDigit(pos, toSort[tmpIdx], radix)]] = toSort[tmpIdx];
    }
    System.arraycopy(tmp, 0, toSort, 0, tmp.length);
  }

  private static int getDigit(int pos, int num, int radix) {
    return num / (int) Math.pow(10, pos) % radix; //10 ^ 0 == 1
  }

  private static int getDigitWithDiv(int pos, int num, int radix) {
    while (pos > 1) {
      num /= radix;
      pos--;
    } return num % radix;
  }
}
