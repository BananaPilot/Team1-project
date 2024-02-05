import classes.warehouse.Zone;
import database.DB;
import in.Input;
import util.Util;


public class Main {
	public static void main(String[] args) {
		Zone zone = new Zone("Falegnameria");
		Zone zone1 = new Zone("Fale");
		Util.printArrayList(DB.getPositions());
		Input.getScanner().close();
	}
}
