package linkedlist;

public class LinkedList {

  private LinkedListNode head;
  private LinkedListNode tail;
  private int size;

  public void printList() {
    if (isEmpty()) {
      System.out.println("Nothing to print !");
      return;
    }
    LinkedListNode current = head;
    current.content();
    while (current.hasNext()) {
      current = current.getNext();
      current.content();
    }
  }

  public void insertAtHead(LinkedListNode newLinkedListNode) {
    if (isNullNode(newLinkedListNode)) return;
    if (isEmpty()) {
      defineHeadAndTail(newLinkedListNode);
      return;
    }
    if (this.contains(newLinkedListNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    head.setPrevious(newLinkedListNode);
    newLinkedListNode.setNext(head);
    newLinkedListNode.setPrevious(null);
    head = newLinkedListNode;
    size++;
  }

  public void insertAtTail(LinkedListNode newLinkedListNode) {
    if (isNullNode(newLinkedListNode)) return;
    if (isEmpty()) {
      defineHeadAndTail(newLinkedListNode);
      return;
    }
    if (this.contains(newLinkedListNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    tail.setNext(newLinkedListNode);
    newLinkedListNode.setPrevious(tail);
    newLinkedListNode.setNext(null);
    tail = newLinkedListNode;
    size++;
  }

  public void insertAt(LinkedListNode newLinkedListNode, int pos) {
    if (isNullNode(newLinkedListNode)) return;
    if (isEmpty()) {
      defineHeadAndTail(newLinkedListNode);
      return;
    }
    if (isInvalidIndex(pos)) {
      System.out.println("The provided index is out of bounds !");
      return;
    }
    if (this.contains(newLinkedListNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    if (size == 0 || pos == 0) insertAtHead(newLinkedListNode);
    if (pos == size + 1) insertAtTail(newLinkedListNode);
    else insert(newLinkedListNode, pos);
  }

  public void addBefore(LinkedListNode toAdd, LinkedListNode before) {
    if (toAdd == null || before == null || !contains(before)) {
      System.out.println("Invalid arguments !");
      return;
    }
    if (contains(toAdd)) {
      System.out.println("Node to add is already in the list !");
      return;
    }
    if (before.equals(head)) {
      insertAtHead(toAdd);
      return;
    }
    LinkedListNode newPrevious = before.getPrevious();
    newPrevious.setNext(toAdd);
    toAdd.setPrevious(newPrevious);
    before.setPrevious(toAdd);
    toAdd.setNext(before);
  }

  private void insert(LinkedListNode newLinkedListNode, int pos) {
    LinkedListNode current = head;
    int insertionPoint = 0;
    while (current.hasNext()) {
      if (insertionPoint == pos) break;
      insertionPoint++;
      current = current.getNext();
    }
    current.getPrevious().setNext(newLinkedListNode);
    newLinkedListNode.setPrevious(current.getPrevious());
    newLinkedListNode.setNext(current);
    current.setPrevious(newLinkedListNode);
    current.setNext(null);
    size++;
  }

  public LinkedListNode removeHead() {
    if (isEmpty()) return null;
    LinkedListNode removed = head;
    LinkedListNode newHead = head.getNext();
    newHead.setPrevious(null);
    removed.setNext(null);
    head = newHead;
    size--;
    return removed;
  }

  public LinkedListNode removeTail() {
    if (isEmpty()) return null;
    LinkedListNode removed = tail;
    LinkedListNode newTail = tail.getPrevious();
    newTail.setNext(null);
    removed.setPrevious(null);
    tail = newTail;
    size--;
    return removed;
  }

  public LinkedListNode remove(int pos) {
    if (isInvalidIndex(pos)) {
      System.out.println("The provided index is out of bounds !");
      return null;
    }
    if (pos == 0 && !isEmpty()) return removeHead();
    if (pos == size - 1) return removeTail();
    LinkedListNode current = head;
    int removalPoint = 0;
    while (current.hasNext()) {
      if (removalPoint == pos) break;
      removalPoint++;
      current = current.getNext();
    }
    LinkedListNode removed = current;
    current.getPrevious().setNext(current.getNext());
    current.getNext().setPrevious(current.getPrevious());
    size--;
    return removed;
  }

  public boolean contains(LinkedListNode n) {
    if (isEmpty()) return false;
    LinkedListNode current = head;
    if (current.equals(n)) return true;
    while (current.hasNext()) {
      current = current.getNext();
      if (current.equals(n)) return true;
    }
    return false;
  }

  private boolean isInvalidIndex(int pos) {
    return pos > size + 1 || pos < 0;
  }

  private boolean isNullNode(LinkedListNode newLinkedListNode) {
    if (newLinkedListNode == null) {
      System.out.println("Cannot insert a null node !");
      return true;
    }
    return false;
  }

  private void defineHeadAndTail(LinkedListNode newLinkedListNode) {
    System.out.println("Linked List has no head. Defining head and tail.");
    head = newLinkedListNode;
    head.setNext(null);
    head.setPrevious(null);
    tail = newLinkedListNode;
    tail.setNext(null);
    tail.setPrevious(null);
    size++;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int getSize() {
    return size;
  }
}
