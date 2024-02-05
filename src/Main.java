import classes.warehouse.Zone;
import database.DB;
import in.Input;
import util.Util;


public class Main {
	public static void main(String[] args) {
		Zone zone = new Zone("Falegnameria");
		Zone zone1 = new Zone("Fale");
		DB.getZones().add(zone);
		DB.getZones().add(zone1);
		Util.printArrayList(DB.getZones().get(0).getPositions());
		System.out.println("-------------------------------------------------------------------------------");
		Util.printArrayList(DB.getZones().get(1).getPositions());
		Input.getScanner().close();
	}
}
