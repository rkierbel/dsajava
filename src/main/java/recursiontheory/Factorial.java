package recursiontheory;

public class Factorial {
  public static void main(String[] args) {
    int rslt = iterative(6);
    int rslt2 = recursive(6);
    System.out.println(rslt + " AND " + rslt2);
  }

  private static int iterative(int num) {
    if (num == 0) return 1;
    int facto = 1;
    for (int i = 1; i <= num; i++) {
      facto *= i;
    }
    return facto;
  }

  private static int recursive(int num) {
    if (num == 0) return 1;
    return num * recursive(num - 1);
  }
}
