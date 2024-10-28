package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DynamicArray {
  public static void addMultipleSameValue(ArrayList<Integer> a, int pos, int num, int val) {
    if (pos < 0 || pos > a.size() || num <= 0)
      return;

    // Thêm giá trị vào ArrayList
    // vòng lặp for sẽ chạy từ 0 đến num - 1
    // và thêm giá trị val vào ArrayList a num lần.
    for (int i = 0; i < num; i++) {
      a.add(val);
    }
    System.out.println(a.toString());

    // Dịch chuyển các phần tử
    // dừng vòng lặp khi i chạm
    // vị trí bắt đầu insert giá trị vào vào mảng
    for (int i = 0; i < a.size() - num - pos; i++) {
      // đưa giá trị đầu tiên từ phải sang trái
      // từ chỗ chèn về cuối mảng
      a.set(a.size() - i - 1, a.get(a.size() - num - i - 1));
    }
    System.out.println(a.toString());

    // Chèn giá trị mới vào ArrayList
    for (int i = 0; i < num; i++) {
      a.set(pos + i, val);
    }
    System.out.println(a.toString());
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    // Set<Integer> a = new Set<Integer>();
    // List<Integer> a = new ArrayList<Integer>();
    a.add(5);
    a.add(1);
    a.add(2);
    a.add(3);

    a.get(0);

    a.get(a.size() - 1);

    a.add(0, 4);

    System.out.println(a.toString());

    addMultipleSameValue(a, 3, 4, 9);

    a.remove(a.size() - 1);

    a.remove(2);

    // 5, 7, 8, 3, 6 -> 5, 3, 6
    a.subList(1, 3).clear();

    // delete all
    a.clear();

    // java không có hàm resize mà phải tự cài đặt bằng tay

    // check Empty()
    if (a.isEmpty() == true) {
      System.out.println("Empty true");
    }

    // contains(value)

    // indexOf(value)

    // duyệt xuôi
    for (int i = 0; i < a.size(); i++) {
      System.out.println(a.get(i) + ", ");
    }

    // duyệt ngược
    for (int i = a.size() - 1; i >= 0; i--) {
      System.out.println(a.get(i) + ", ");
    }

    // 2d array
    ArrayList<ArrayList<Integer>> arr2ArrayList = new ArrayList<ArrayList<Integer>>();
  }
}
