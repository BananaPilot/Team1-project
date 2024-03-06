package com.team1.app.classes.shared;

public class ExceptionHandler {
    public void handle(Exception e) {
        if (e instanceof IllegalStateException){
            if (!e.getMessage().contains("0")) {
                System.err.println(e.getMessage());
            }
        } else System.err.println(e.getMessage());
    }
}
