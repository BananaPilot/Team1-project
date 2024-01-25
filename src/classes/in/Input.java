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

  public static int getInt(){
    int input = getScanner().nextInt();
    getScanner().nextLine();
    return input;
  }

  public static String getString(String description){
    System.out.println(description);
    return getScanner().nextLine();
  }
}
