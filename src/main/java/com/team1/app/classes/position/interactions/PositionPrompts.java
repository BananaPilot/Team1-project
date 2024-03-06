package com.team1.app.classes.position.interactions;

public class PositionPrompts {
    private PositionPrompts() {}
    public static void positionMainPrompt() {
        System.out.println("1. List all position com.team1.app.classes.in a zone");
        System.out.println("2. List a specific position com.team1.app.classes.in a zone");
    }

    public static void positionSearchPrompt() {
        System.out.println("1. Search by lot");
        System.out.println("2. Search by state (empty/full)");
    }
}
