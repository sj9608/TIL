import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int h, m;
    h = sc.nextInt();
    m = sc.nextInt();

    if (h < 1 && m < 45) System.out.printf("%d %d", 23, m + 15);
    else if (m < 45) System.out.printf("%d %d", h - 1, m + 15);
    else System.out.printf("%d %d", h, m - 45);
  }
}
