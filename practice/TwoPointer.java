package practice;

import java.util.ArrayList;
import java.util.Arrays;

// Cho mảng A đã được sắp xếp asc
// { -3, 02, 0, 1, 2, 3, 4, 7}
// tìm 2 phần tử A[i] and A[j] such that
// A[i] + A[j] = 0 and i != j
public class TwoPointer {

  public static void foo2(ArrayList<Integer> arr) {
    int n = arr.size();

    // Time complexity: O(n)
    int left = 0;
    int right = n - 1;

    while (left < right) {
      int temp = arr.get(left) + arr.get(right);
      if (temp == 0) {
        System.out.println("Value i " + left + " Value j " + right);
        return;
      }
      if (temp > 0)
        right = right - 1;
      if (temp < 0)
        left = left + 1;
    }
  }

  public static void foo1(ArrayList<Integer> arr) {
    int n = arr.size();

    // Time complexity: O(n^2)
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = arr.get(i) + arr.get(j);
        if (temp == 0) {
          System.out.println("Value i " + i + " Value j " + j);
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-3, 0, 2, 1, 2, 3, 4, 7));
    // foo1(arr);
    foo2(arr);
  }
}
