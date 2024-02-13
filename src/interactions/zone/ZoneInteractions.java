package interactions.zone;

import CRUD.zone.ZoneCRUD;
import classes.database.DB;
import classes.warehouse.Zone;
import in.Input;
import prompts.zone.ZonePrompts;

import java.util.ArrayList;

public class ZoneInteractions {
    private final ArrayList<Zone> zones = DB.getInstance().getZones();
    private final ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void zoneHandler(){
        int input;
        do {
            ZonePrompts.zoneMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> zones.add(zoneCRUD.createZone());
                case 2 -> zoneCRUD.listZones(zones);
                case 3 -> zoneCRUD.getZone(zones);
                case 4 -> zoneCRUD.updateZone(zones);
                case 5 -> zones.remove(zoneCRUD.getZone(zones));
            }
        } while (input != 0);
    }
}
