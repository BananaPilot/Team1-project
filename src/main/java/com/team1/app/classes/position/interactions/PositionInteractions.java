package com.team1.app.classes.position.interactions;

import com.team1.app.classes.in.Input;

public class PositionInteractions {
    PositionCRUD positionCRUD = new PositionCRUD();

    public void positionHandler() {
        int input;
        do {
            PositionPrompts.positionMainPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> positionCRUD.listPositions();
                case 2 -> positionCRUD.getPosition();
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}

