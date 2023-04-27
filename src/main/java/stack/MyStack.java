package stack;

public interface MyStack<E> {

  boolean push(E elem);

  E pop();

  E peek();
}
