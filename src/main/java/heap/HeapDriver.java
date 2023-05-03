package heap;

public class HeapDriver {

  public static void main(String[] args) {
    long[] toSort = new long[]{3L, 49L, 50L, 1L, -2L, 333L, 2L, 1L, 33L};

    Heap.goHeapSort(toSort, toSort.length);
  }
}
