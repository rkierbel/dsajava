package linkedlist;

public class LinkedListDriver {

  public static void main(String[] args) {
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    LinkedList ll = new LinkedList();
    ll.insertAt(A, 0);
    ll.insertAtTail(C);
    ll.insertAt(B, 1);
    ll.printList();
    ll.insertAtHead(B); //will fail -> no duplicates
    System.out.println("REMOVED : ");
    ll.remove(1).content();
    System.out.println("---------------");
    ll.addBefore(D, A);
    ll.addBefore(B, A);
    ll.printList();
  }
}
