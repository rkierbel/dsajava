package heap;

public class Heap {

  PriorityQueue queue;

  int parent(int n) {
    if (n == 1) return -1;
    else return n / 2;
  }

  int child(int n) {
    return n * 2;
  }

  Heap makeHeap(long[] input, int n) {
    Heap current = new Heap();
    current.priorityQueueInit();
    for (int i = 0; i < n; i++) {
      insert(current.queue, input[i]);
    }
    return current;
  }

  void priorityQueueInit() {
    this.queue = new PriorityQueue(0);
  }

  void insert(PriorityQueue q, long item) {
    if (q.n >= q.queue.length) System.out.println("Queue overflow!");
    else {
      q.n += 1;
      q.queue[q.n] = item;
      bubbleUp(q, q.n);
    }
  }

  private void bubbleUp(PriorityQueue q, int p) {
    if (parent(p) == -1) {
      System.out.println("At root of heap, no parent");
    }
    if (q.queue[parent(p)] > q.queue[p]) {
      swap(q, p, parent(p));
      bubbleUp(q, parent(p));
    }
  }

  private void swap(PriorityQueue q, int child, int parent) {
    long tmp = q.queue[parent];
    q.queue[parent] = q.queue[child];
    q.queue[child] = tmp;
  }

  private final class PriorityQueue {
    int n;
    long[] queue;

    public PriorityQueue(int n) {
      this.n = n;
    }
  }
}
