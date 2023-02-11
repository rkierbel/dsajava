package linkedlist;

public class LinkedList {

  private Node head;
  private Node tail;
  private int size;

  public void printList() {
    if (head == null) {
      System.out.println("Nothing to print !");
      return;
    }
    Node current = head;
    current.content();
    while (current.hasNext()) {
      current = current.getNext();
      current.content();
    }
  }

  public void insertAtHead(Node newNode) {
    if (isNullNode(newNode)) return;
    if (head == null) {
      defineHeadAndTail(newNode);
      return;
    }
    if (this.contains(newNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    head.setPrevious(newNode);
    newNode.setNext(head);
    newNode.setPrevious(null);
    head = newNode;
    size++;
  }

  public void insertAtTail(Node newNode) {
    if (isNullNode(newNode)) return;
    if (head == null) {
      defineHeadAndTail(newNode);
      return;
    }
    if (this.contains(newNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    tail.setNext(newNode);
    newNode.setPrevious(tail);
    newNode.setNext(null);
    tail = newNode;
    size++;
  }

  public void insertAt(Node newNode, int pos) {
    if (isNullNode(newNode)) return;
    if (head == null) {
      defineHeadAndTail(newNode);
      return;
    }
    if (isInvalidIndex(pos)) {
      System.out.println("The provided index is out of bounds !");
      return;
    }
    if (this.contains(newNode)) {
      System.out.println("Node already in the list !");
      return;
    }
    if (size == 0 || pos == 0) insertAtHead(newNode);
    if (pos == size + 1) insertAtTail(newNode);
    else insert(newNode, pos);
  }

  private void insert(Node newNode, int pos) {
    Node current = head;
    int insertionPoint = 0;
    while (current.hasNext()) {
      if (insertionPoint == pos) break;
      insertionPoint++;
      current = current.getNext();
    }
    current.getPrevious().setNext(newNode);
    newNode.setPrevious(current.getPrevious());
    newNode.setNext(current);
    current.setPrevious(newNode);
    current.setNext(null);
    size++;
  }

  public Node removeHead() {
    if (head == null) return null;
    Node removed = head;
    Node newHead = head.getNext();
    newHead.setPrevious(null);
    head = newHead;
    size--;
    return removed;
  }

  public Node removeTail() {
    if (tail == null) return null;
    Node removed = tail;
    Node newTail = tail.getPrevious();
    newTail.setNext(null);
    tail = newTail;
    size--;
    return removed;
  }

  public Node remove(int pos) {
    if (isInvalidIndex(pos)) {
      System.out.println("The provided index is out of bounds !");
      return null;
    }
    if (pos == 0) return removeHead();
    if (pos == size - 1) return removeTail();
    Node current = head;
    int removalPoint = 0;
    while (current.hasNext()) {
      if (removalPoint == pos) break;
      removalPoint++;
      current = current.getNext();
    }
    Node removed = current;
    current.getPrevious().setNext(current.getNext());
    current.getNext().setPrevious(current.getPrevious());
    size--;
    return removed;
  }

  public boolean contains(Node n) {
    if (head == null) return false;
    Node current = head;
    if (this.size == 1) return current.equals(n);
    while (current.hasNext()) {
      if (current.equals(n)) return true;
      current = current.getNext();
    } return false;
  }

  private boolean isInvalidIndex(int pos) {
    return pos > size + 1 || pos < 0;
  }

  private boolean isNullNode(Node newNode) {
    if (newNode == null) {
      System.out.println("Cannot insert a null node !");
      return true;
    }
    return false;
  }

  private void defineHeadAndTail(Node newNode) {
    System.out.println("Linked List has no head. Defining head and tail.");
    head = newNode;
    head.setNext(null);
    head.setPrevious(null);
    tail = newNode;
    tail.setNext(null);
    tail.setPrevious(null);
    size++;
  }

  public int getSize() {
    return size;
  }
}
