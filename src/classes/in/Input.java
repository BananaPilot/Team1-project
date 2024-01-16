package classes.in;

import java.util.Scanner;

public class Input {
  private Input() {}
  private final static Scanner scanner = new Scanner(System.in);
  public static Scanner getScanner() {
    return scanner;
  }
}
