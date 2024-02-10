package interactions.zone;

import CRUD.zone.ZoneCRUD;
import classes.database.DB;
import in.Input;
import prompts.zone.ZonePrompts;

public class ZoneIntractions {
    private ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void zoneHandler(){
        int input;
        do {
            ZonePrompts.zoneMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> DB.getZones().add(zoneCRUD.createZone());
                case 2 -> zoneCRUD.listZones(DB.getZones());
                case 3 -> zoneCRUD.getZone();
                case 4 -> zoneCRUD.updateZone();
                case 5 -> DB.getZones().remove(zoneCRUD.getZone());
            }
        } while (input != 0);
    }
}
