import java.util.Scanner;

class Sample {
  public static void main(String[] args) {
    // Create object Scanner
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String yourName = scanner.nextLine();
    System.out.println("Your name is " + yourName);

    // Caculate int number
    System.out.println("Enter x: ");
    int x = scanner.nextInt();
    System.out.println("Enter y");
    int y = scanner.nextInt();
    int resultSum = x + y;
    System.out.println("Sum x + yC : " + resultSum);

    int resultSub = x - y;
    System.out.println("Sub x - y: " + resultSub);

    // free up resource
    scanner.close();
  }

}