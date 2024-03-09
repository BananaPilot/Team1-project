package com.team1.app.classes.shared;

import java.util.concurrent.TimeUnit;

public class ExceptionHandler {
    public void handle(Exception e) {
        if (e instanceof IllegalStateException){
            if (!e.getMessage().contains("0")) {
                System.err.println(e.getMessage());
            }
        } else System.err.println(e.getMessage());

        //ensures proper formatting of error keep it here
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (Exception exception){
            e.printStackTrace();
        }
    }
}
