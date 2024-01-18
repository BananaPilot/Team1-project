import classes.WarehouseLogic.WarehouseLogic;
import classes.in.Input;
import classes.warehouse.Warehouse;

public class Main {
  public static void main(String[] args) {

    WarehouseLogic.createZone("bici",2,2);
    WarehouseLogic.createZone("pippi",2,2);

    WarehouseLogic.stockingManagement(3,1,"shampo","panthene","contro zecche e zanzare",3.22);
    WarehouseLogic.stockingManagement(3,2,"sdadadadao","panthene","contro zecche e zanzare",3.22);

  }
}

