import classes.database.DB;
import classes.interfaces.Searchable;
import classes.warehouse.Position;
import classes.warehouse.Zone;
import in.Input;
import interactions.customer.CustomerInteractions;

public class Main {
  public static void main(String[] args) {
    DB.getZones().add(new Zone("falegnameria"));
    System.out.println(Searchable.search(DB.getZones().get(0).getPositions(), "2L0", "false"));
    Input.getScanner().close();
  }
}

