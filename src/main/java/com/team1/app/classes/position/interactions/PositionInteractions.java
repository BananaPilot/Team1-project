package com.team1.app.classes.position.interactions;

import com.team1.app.classes.in.In;
import com.team1.app.classes.shared.ExceptionHandler;

public class PositionInteractions {
    PositionCRUD positionCRUD = new PositionCRUD();

    public void positionHandler() {
        int input;
        try{
            do {
                PositionPrompts.positionMainPrompt();
                input = In.getInstance().getInput();
                switch (input) {
                    case 1 -> positionCRUD.listPositions();
                    case 2 -> positionCRUD.getPosition();
                    default -> System.out.println("Unexpected value: " + input);
                }
            } while (input != 0);
        }catch(Exception e){
            new ExceptionHandler().handle(e);
        }
    }
}

