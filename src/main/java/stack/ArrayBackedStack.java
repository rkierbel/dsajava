package stack;

public class ArrayBackedStack implements MyStack<StackNode>{

  private StackNode[] stack;

  @Override
  public boolean push(StackNode elem) {
    return false;
  }

  @Override
  public StackNode pop() {
    return null;
  }

  @Override
  public StackNode peek() {
    return null;
  }
}
