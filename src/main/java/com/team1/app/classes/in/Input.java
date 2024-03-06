package com.team1.app.classes.in;

import com.team1.app.classes.shared.ExceptionHandler;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private static Input input;

    public static Input getInstance() {
        if (input == null) {
            input = new Input();
        }
        return input;
    }

    public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public int getInput() {
        try {
            System.out.print("Input: ");
            int input = getScanner().nextInt();
            getScanner().nextLine();
            return input;
        } catch (Exception e){
            exceptionHandler.handle(e);
        }
        return -1;
    }

    public int getInt(String description) {
        try {
            System.out.print(description);
            int input = getScanner().nextInt();
            getScanner().nextLine();
            return input;
        } catch (Exception e){
            exceptionHandler.handle(e);
        }
        return -1;
    }

    public double getDouble(String description) {
        try {
            System.out.print(description);
            double input = getScanner().nextDouble();
            getScanner().nextLine();
            return input;
        } catch (Exception e) {
            exceptionHandler.handle(e);
        }
        return -1;
    }

    public String getString(String description) {
        System.out.print(description);
        return getScanner().nextLine();
    }
}
