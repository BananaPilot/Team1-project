package classes.warehouse;

import classes.database.DB;
import classes.interfaces.Searchable;

import java.util.ArrayList;

public class Warehouse implements Searchable {
    private final ArrayList<Zone> zones = DB.getInstance().getZones();
}
