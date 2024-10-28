package practice;

public class AlgorithmicComplexity {

  public static int foo(int n) {
    int i;
    int sum;

    if (n == 0)
      return 1;
    else {
      sum = 0;
      for (i = 0; i < n; i++) {
        sum = sum + foo(i);
      }
      return sum;
    }
  }

  public static int findFibonaci(int n) {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else
      return findFibonaci(n - 1) + findFibonaci(n - 2);
  }

  public static void complexityEx1(int N) {
    int count = 0;
    int i = N;
    // the outer while loop runs log(N) times
    // because i is halved at each iteration until it becomes 0

    while (i > 0) {
      // N + N/2 + N/4 + ... + 1 = N(1 + 1/2 + 1/4 + ... + 1/(2^k))
      for (int j = 0; j < i; j++) {
        count = count + 1;
      }
      i = i / 2;
    }

  }

  public static void main(String[] args) {
    // complexityEx1(1000);
    System.out.println(foo(10));
  }
}
