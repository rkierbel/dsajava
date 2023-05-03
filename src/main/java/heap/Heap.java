package heap;

public class Heap {

  PriorityQueue PQ;
  int queueSize;

  public Heap(int n) {
    this.queueSize = n;
  }

  public static void goHeapSort(long[] input, int n) {
    Heap built = new Heap(n);
    built = built.make(input, n);
    built.heapSort(input, n);
  }

  void heapSort(long[] input, int n) {
    for (int i = 0; i < n; i++) input[i] = extractMin(this.PQ);
  }

  Heap make(long[] input, int n) {
    this.priorityQueueInit();
    for (int i = 0; i < n; i++) {
      insert(this.PQ, input[i]);
    }
    return this;
  }

  void priorityQueueInit() {
    this.PQ = new PriorityQueue(0, this.queueSize + 1);
  }

  void insert(PriorityQueue q, long item) {
    if (q.n >= this.queueSize) System.out.println("Queue overflow!");
    else {
      q.n += 1;
      q.queue[q.n] = item;
      bubbleUp(q, q.n);
    }
  }

  private void bubbleUp(PriorityQueue q, int p) {
    if (q.parent(p) == -1) {
      System.out.println("At root of heap, no parent");
      return;
    }
    if (q.queue[q.parent(p)] > q.queue[p]) {
      swap(q, p, q.parent(p));
      bubbleUp(q, q.parent(p));
    }
  }

  private void swap(PriorityQueue q, int child, int parent) {
    long tmp = q.queue[parent];
    q.queue[parent] = q.queue[child];
    q.queue[child] = tmp;
  }

  long extractMin(PriorityQueue q) {
    if (q.n <= 0) {
      throw new IllegalStateException("Empty queue");
    } else {
      long min = q.queue[1];
      q.queue[1] = q.queue[q.n];
      q.n -= 1;
      bubbleDown(q, 1);
      return min;
    }
  }

  void bubbleDown(PriorityQueue q, int p) {
    int childIdx = q.child(p);
    int minIdx = p;

    for (int i = 0; i <= 1; i++) {
      if ((childIdx + i) <= q.n) {
        if (q.queue[minIdx] > q.queue[childIdx + i]) {
          minIdx = childIdx + i;
        }
      }
    }

    if (minIdx != p) {
      swap(q, p, minIdx);
      bubbleUp(q, minIdx);
    }
  }

  private static final class PriorityQueue {
    int n;
    long[] queue;

    public PriorityQueue(int elems, int size) {
      this.n = elems;
      queue = new long[size];
    }

    int parent(int n) {
      if (n == 1) return -1;
      else return n / 2;
    }

    int child(int n) {
      return n * 2;
    }
  }
}
