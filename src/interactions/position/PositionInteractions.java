package interactions.position;

import CRUD.position.PositionCRUD;
import in.Input;
import prompts.position.PositionPrompts;

public class PositionInteractions {
    PositionCRUD positionCRUD = new PositionCRUD();

    public void positionHandler() {
        int input;
        do {
            PositionPrompts.positionMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> positionCRUD.listPositions();
                case 2 -> positionCRUD.getPosition();
            }
        } while (input != 0);
    }
}

