package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingFraction {
  public static void main(String[] args) {
    ArrayList<Fraction> v = new ArrayList<Fraction>();
    v.add(new Fraction(5, 5));
    v.add(new Fraction(3, 2));
    v.add(new Fraction(1, 9));
    v.add(new Fraction(3, 8));

    Collections.sort(v, new Comparator<Fraction>() {
      @Override
      public int compare(Fraction o1, Fraction o2) {
        return ((Double) (1.0 * o1.numerator / o1.denominator))
            .compareTo((Double) (1.0 * o2.numerator / o2.denominator));
      }
    });

    // print array of address objects
    System.out.println(v.toString());

    for (int i = 0; i < v.size(); i++) {
      // use System.out.printf instead of System.out.println because
      // System.out.println
      // does not support formatted strings like the one you are using.
      System.out.printf("%d / %d, ", v.get(i).numerator, v.get(i).denominator);
    }

  }

  // using static class to easy compile by using cli
  static class Fraction {
    public Integer numerator;
    public Integer denominator;

    Fraction(int num, int denom) {
      numerator = num;
      denominator = denom;
    }
  }
}
