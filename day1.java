
// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.io.*;

class DayOne {
  private static void printZooInfo(boolean isWeekend) {
    final int giraffe = 4;
    final long lemur;
    if (isWeekend)
      lemur = 5;
    else
      lemur = 3;
    System.out.println(giraffe + " " + lemur);
  }

  public static void main(String[] args) {
    printZooInfo(true);
  }
}
