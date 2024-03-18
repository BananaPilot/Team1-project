package com.team1.app.classes.position.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.position.Position;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.zone.interactions.ZoneCRUD;
import com.team1.app.classes.in.In;
import com.team1.app.classes.util.Util;

import java.util.ArrayList;
import java.util.List;

public class PositionCRUD {
    ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void listPositions() {
        Util.printArrayList(zoneCRUD.getZone(DB.getInstance().getZones()).getPositions());
    }

    public Position getPosition() {
        PositionPrompts.positionSearchPrompt();
        int input = In.getInstance().getInput();
        switch (input) {
            case 1 -> {
                return Searchable.search(zoneCRUD.getZone(DB.getInstance().getZones()).getPositions(), In.getInstance().getString("Lot: "));
            }
            case 2 -> System.out.println(getPositionsByState());
            case 0 -> System.out.println("Going back");
            default -> throw new IllegalStateException("Unexpected value: " + input);
        }
        return null;
    }

    public List<Position> getPositionsByState() {
        ArrayList<Position> positions = new ArrayList<>();
        String state = In.getInstance().getString("State: ");
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
