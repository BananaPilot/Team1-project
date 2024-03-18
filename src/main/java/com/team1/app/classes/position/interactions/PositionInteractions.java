package com.team1.app.classes.position.interactions;

import com.team1.app.classes.in.In;
import com.team1.app.classes.shared.ExceptionHandler;

public class PositionInteractions {
    PositionCRUD positionCRUD = new PositionCRUD();

    public void positionHandler() {
        int input;

        do {
            PositionPrompts.positionMainPrompt();
            input = In.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> positionCRUD.listPositions();
                    case 2 -> positionCRUD.getPosition();
                    case 0 -> System.out.println("Going back");
                    default -> System.out.println("Unexpected value: " + input);
                }
            } catch (Exception e) {
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);

    }
}

