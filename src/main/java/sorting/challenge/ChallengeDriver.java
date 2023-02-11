package sorting.challenge;

import java.util.Arrays;

public class ChallengeDriver {

  public static void main(String[] args) {
    int[] firstChallenge = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    One.mergeSort(firstChallenge, 0, firstChallenge.length);
    System.out.println("ASCENDING MERGE SORTED ! " + Arrays.toString(firstChallenge));

    int[] secondChallenge = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    Two.recursiveInsertionSort(secondChallenge, 0);
    System.out.println("RECURSIVE INSERTION SORTED ! " + Arrays.toString(secondChallenge));
  }
}
