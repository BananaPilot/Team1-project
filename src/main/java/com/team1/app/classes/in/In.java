package com.team1.app.classes.in;

import com.team1.app.classes.shared.ExceptionHandler;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class In {

    private In() {

    }

    private Scanner scanner;
    static ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static In input;

    public static In getInstance() {
        if (input == null) {
            input = new In();
        }
        return input;
    }

    public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public Integer getInput() {
        String input;
        boolean flag = false;
        do {
            input = getString("input: ");
            try {
                flag = true;
                return Integer.parseInt(input);
            } catch (Exception e){
                exceptionHandler.handle(e);
            }
        } while (flag);
        return null;
    }

    public Integer getInt(String description) {
        String input = getString(description);
        try {
            return Integer.parseInt(input);
        } catch (Exception e){
            exceptionHandler.handle(e);
        }
        return null;
    }

    public Double getDouble(String description) {
        String input = getString(description);
        try {
            return Double.parseDouble(input);
        } catch (Exception e){
            exceptionHandler.handle(e);
        }
        return null;
    }

    public String getString(String description) {
        System.out.print(description);
        return getScanner().nextLine();
    }
}
