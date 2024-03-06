package com.team1.app;

import com.team1.app.classes.MainInteraction;
import com.team1.app.classes.shared.ExceptionHandler;
import com.team1.app.classes.in.Input;

public class Main {
    public static void main(String[] args) {
        try {
            new MainInteraction().mainHandler();
        } catch (InterruptedException e) {
            new ExceptionHandler().handle(e);
        }
        Input.getInstance().getScanner().close();
    }
}