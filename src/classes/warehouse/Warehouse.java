package classes.warehouse;

import classes.database.DB;

import java.util.ArrayList;

public class Warehouse {
    private final ArrayList<Zone> zones = DB.getZones();
}