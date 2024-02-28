package classes.zone.interactions;

import classes.database.DB;
import classes.zone.Zone;
import in.Input;

import java.util.ArrayList;

public class ZoneInteractions {
    private final ArrayList<Zone> zones = DB.getInstance().getZones();
    private final ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void zoneHandler(){
        int input;
        do {
            ZonePrompts.zoneMainPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> zones.add(zoneCRUD.createZone());
                case 2 -> zoneCRUD.listZones(zones);
                case 3 -> zoneCRUD.getZone(zones);
                case 4 -> zoneCRUD.updateZone(zones);
                case 5 -> zones.remove(zoneCRUD.getZone(zones));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}
