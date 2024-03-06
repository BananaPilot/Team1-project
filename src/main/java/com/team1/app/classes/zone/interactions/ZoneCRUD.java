package com.team1.app.classes.zone.interactions;

import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.zone.Zone;
import com.team1.app.classes.in.Input;
import com.team1.app.classes.util.Util;

import java.util.List;

public class ZoneCRUD {

    public Zone createZone() {
        return new Zone(Input.getInstance().getString("Sector name: "));
    }

    public void listZones(List<Zone> zones) {
        Util.printArrayList(zones);
    }

    public Zone getZone(List<Zone> zones) {
        ZonePrompts.zoneSearchPrompt();
        int input = Input.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(zones, Input.getInstance().getString("Sector name: "));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateZone(List<Zone> zones) {
        Zone zone = getZone(zones);
        if (zone == null) {
            return;
        }
        int input;
        do {
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> zone.setSector(Input.getInstance().getString("New sector game: "));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);

        System.out.println("updated sector: " + zone);
    }
}
