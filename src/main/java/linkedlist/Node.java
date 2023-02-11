package linkedlist;

public class Node {

  private Node next;
  private Node previous;
  private final String content;

  public Node(String content) {
    this.content = content;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrevious() {
    return previous;
  }

  public void setPrevious(Node previous) {
    this.previous = previous;
  }

  public void content() {
    String prefix = """
             _________
            |         |""";
    System.out.println(prefix);
    System.out.println("|    " + content + "    |");
    String suffix = """
            |         |
            |_________|""";
    System.out.println(suffix);
  }

  public boolean hasNext() {
    return this.next != null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!(obj instanceof Node n)) return false;
    return this.content.equals(n.content);
  }
}
