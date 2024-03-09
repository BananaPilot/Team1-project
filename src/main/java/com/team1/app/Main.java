package com.team1.app;

import com.team1.app.classes.MainInteraction;
import com.team1.app.classes.in.In;

public class Main {
    public static void main(String[] args) {
        new MainInteraction().mainHandler();
        In.getInstance().getScanner().close();
    }
}