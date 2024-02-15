package CRUD.position;

import CRUD.zone.ZoneCRUD;
import classes.database.DB;
import classes.interfaces.Searchable;
import classes.warehouse.Position;
import classes.warehouse.Zone;
import in.Input;
import prompts.position.PositionPrompts;
import util.Util;

import java.util.ArrayList;

public class PositionCRUD {
    ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void listPositions() {
        Util.printArrayList(zoneCRUD.getZone(DB.getInstance().getZones()).getPositions());
    }

    public Position getPosition() {
        PositionPrompts.positionSearchPrompt();
        int input = Input.getInput();
        switch (input) {
            case 1 -> {
                return (Position) Searchable.search(zoneCRUD.getZone(DB.getInstance().getZones()).getPositions(), Input.getString("Lot: "));
            }
            case 2 -> System.out.println(getPositionsByState());
            default -> throw new IllegalStateException("Unexpected value: " + input);
        }
        ;
        return null;
    }

    public ArrayList<Position> getPositionsByState() {
        ArrayList<Position> positions = new ArrayList<>();
        String state = Input.getString("State: ");
        if (state.equals("true") || state.equals("false")) {
            for (Position position : zoneCRUD.getZone(DB.getInstance().getZones()).getPositions()) {
                if (position.contains(state)) positions.add(position);
            }
        } else {
            System.err.println("Something went wrong");
        }
        return positions;
    }
}
