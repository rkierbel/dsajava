package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] toSort = new int[]{5, 60, 35, 20, 1, -22, 55, -16, 7};
    System.out.println("WILL SORT " + Arrays.toString(toSort));
    mergeSort(toSort, 0, toSort.length);
    System.out.println("SORTED ! " + Arrays.toString(toSort));
  }

  private static void mergeSort(int[] toSort, int start, int end) {
    if (end - start < 2) return;
    int mid = (start + end) / 2;
    mergeSort(toSort, start, mid); //sort left part entirely - stops recursive calls when start == end
    mergeSort(toSort, mid, end); //sort right part entirely
    merge(toSort, start, mid, end); //sort both pre-sorted left and right parts -> start merging when no more breakdown
  }

  // Remember when calling merge(), we're always merging sorted arrays
  private static void merge(int[] toMerge, int start, int mid, int end) {
    /* toMerge[mid - 1] is the last elem in the left partition and toMerge[mid] is the first elem in the right partition.
    This condition means that all the elements in the left partition are lesser than or equal to
    the smallest element in the right partition (because both partitions are sorted!) => nothing to merge! */
    if (toMerge[mid - 1] <= toMerge[mid]) return;

    int i = start;
    int j = mid;
    int tmpIndex = 0;
    int[] tmp = new int[end - start];

    /* Goal is to copy tmp[] back into toSort[] at the same position, with the correct ordering.
    Let left[]{32, 34} and right[]{33, 36}.
    Traversing the while loop below would result in tmp[]{32, 33, 34} and exiting loop because i == mid.
    36 would remain in the right partition.
    No need to copy 36 in tmp[] because it is already at its correct position in toMerge[].
    If we have elements remaining the right partition after we've entirely copied the left partition in tmp[],
    it means all these elements are greater than everything that has already been copied in tmp[].
    The position of the remaining elements in the right partition is not going to change as a result of the merge.
    Hence, copying these elements into tmp[] is not necessary.
    tmp[] will contain 32, 33, 34.

    Let left[]{32, 36} and right[]{33, 34}.
    Traversing the while loop below would result in tmp[](32, 33, 34) and exiting loop because j == end.
    The position of 36 will have to change from index 1 to index 3.
    We will perform the copy directly from one location to another in toMerge[].
    tmp[] will contain 32, 33, 34. */
    while (i < mid && j < end) {
      tmp[tmpIndex++] = toMerge[i] <= toMerge[j] ? toMerge[i++] : toMerge[j++];
    }

    /* Copy unhandled elements from left partition.
    We don't copy the unhandled elements from the left partition into tmp[],
    we copy them directly into toMerge[] (from one location to another).
    i -> first index of elements remaining in the left partition;
    destPos -> tmpIndex counted how many elems we've handled;
    mid - i -> provides the number of elements not copied into tmp[], that need to be copied into toMerge[]
    (if mid - i == 0 -> no copy)
    Let's say we are merging two, two element arrays. We've copied three elements in tmp[].
    We have one remaining element in the left partition (in our example above, 36).
    We'll add 3 (tmpIndex) to the start index, so the unhandled element will be copied into the original array,
    at the position right after the elements we're gonna copy in there from tmp[]. */
    System.arraycopy(toMerge, i, toMerge, start + tmpIndex, mid - i);

    // Copy sorted merged elements from tmp[] to toMerge[]
    System.arraycopy(tmp, 0, toMerge, start, tmpIndex);
  }
}
