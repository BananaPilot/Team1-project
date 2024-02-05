package classes.warehouse;

import database.DB;

import java.util.ArrayList;

public class Warehouse {
  private final ArrayList<Zone> zones = DB.getZones();
}
