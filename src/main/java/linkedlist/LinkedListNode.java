package linkedlist;

public class LinkedListNode {

  private LinkedListNode next;
  private LinkedListNode previous;
  private final String content;

  public LinkedListNode(String content) {
    this.content = content;
  }

  public LinkedListNode getNext() {
    return next;
  }

  public void setNext(LinkedListNode next) {
    this.next = next;
  }

  public LinkedListNode getPrevious() {
    return previous;
  }

  public void setPrevious(LinkedListNode previous) {
    this.previous = previous;
  }

  public void content() {
    String prefix = """
             _________
            |         |""";
    String suffix = """
            |_________|""";

    System.out.println(prefix);
    System.out.println("|    " + content + "    |");
    System.out.println(suffix);
  }

  public boolean hasNext() {
    return this.next != null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!(obj instanceof LinkedListNode n)) return false;
    return this.content.equals(n.content);
  }
}
