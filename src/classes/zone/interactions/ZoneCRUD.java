package classes.zone.interactions;

import classes.shared.Searchable;
import classes.zone.Zone;
import in.Input;
import util.Util;

import java.util.ArrayList;

public class ZoneCRUD {

    public Zone createZone() {
        return new Zone(Input.getString("Sector name: "));
    }

    public void listZones(ArrayList<Zone> zones) {
        Util.printArrayList(zones);
    }

    public Zone getZone(ArrayList<Zone> zones) {
        ZonePrompts.zoneSearchPrompt();
        int input = Input.getInput();
        return switch (input) {
            case 1 -> Searchable.search(zones, Input.getString("Sector name: "));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateZone(ArrayList<Zone> zones) {
        Zone zone = getZone(zones);
        if (zone == null) {
            return;
        }
        int input;
        do {
            input = Input.getInput();
            switch (input) {
                case 1 -> zone.setSector(Input.getString("New sector game: "));
            }
        } while (input != 0);

        System.out.println("updated sector: " + zone);
    }
}
