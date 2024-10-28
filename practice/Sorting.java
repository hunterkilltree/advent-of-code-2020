package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sorting
 */
public class Sorting {
  public static void main(String[] args) {
    int[] arr = { 4, 1, 2, 3, 5, 0 };

    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    Integer[] arr2 = new Integer[] { 4, 1, 2, 3, 5, 0 };
    Arrays.sort(arr2, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });
    System.out.println(Arrays.toString(arr2));

    ///////// DESC ////////////
    Integer[] arr3 = new Integer[] { 4, 1, 2, 3, 5, 0 };
    Arrays.sort(arr3, Collections.reverseOrder());
    System.out.println(Arrays.toString(arr3));

    Integer[] arr4 = new Integer[] { 4, 1, 2, 3, 5, 0 };
    Arrays.sort(arr4, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    System.out.println(Arrays.toString(arr4));

    Integer[] arr5 = new Integer[] { 4, 1, 2, 3, 5, 0 };
    // lamda funtion >= java 8
    Arrays.sort(arr5, (o1, o2) -> o2.compareTo(o1));
    System.out.println(Arrays.toString(arr5));
    // chỉ sử dụng được với object data không sử dụng được với primitive data
    System.exit(0);
  }

}