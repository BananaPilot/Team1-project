package classes.in;

import java.util.Scanner;

public class Input {
  private Input() {}
  private static Scanner scanner;
  public static Scanner getScanner() {
    if (scanner == null) {
      scanner = new Scanner(System.in);
    }
    return scanner;
  }
}
