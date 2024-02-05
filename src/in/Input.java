package in;

import java.util.Scanner;

public class Input {
    private Input() {
    }

    private static Scanner scanner;

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static int getInput() {
        System.out.print("Input: ");
        int input = getScanner().nextInt();
        getScanner().nextLine();
        return input;
    }

    public static int getInt(String description) {
        System.out.print(description);
        int input = getScanner().nextInt();
        getScanner().nextLine();
        return input;
    }

    public static Double getDouble(String description) {
        System.out.print(description);
        Double input = getScanner().nextDouble();
        getScanner().nextLine();
        return input;
    }

    public static String getString(String description) {
        System.out.print(description);
        return getScanner().nextLine();
    }
}
