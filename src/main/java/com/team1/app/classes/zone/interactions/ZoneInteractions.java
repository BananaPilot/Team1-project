package com.team1.app.classes.zone.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.shared.ExceptionHandler;
import com.team1.app.classes.zone.Zone;
import com.team1.app.classes.in.In;

import java.util.List;

public class ZoneInteractions {
    private final List<Zone> zones = DB.getInstance().getZones();
    private final ZoneCRUD zoneCRUD = new ZoneCRUD();

    public void zoneHandler(){
        int input;
        try {
            do {
                ZonePrompts.zoneMainPrompt();
                input = In.getInstance().getInput();
                switch (input) {
                    case 1 -> zones.add(zoneCRUD.createZone());
                    case 2 -> zoneCRUD.listZones(zones);
                    case 3 -> zoneCRUD.getZone(zones);
                    case 4 -> zoneCRUD.updateZone(zones);
                    case 5 -> zones.remove(zoneCRUD.getZone(zones));
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                }
            } while (input > 0);
        }catch (IllegalArgumentException e){
            new ExceptionHandler().handle(e);
        }
    }
}
