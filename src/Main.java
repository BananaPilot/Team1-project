import classes.WarehouseLogic.WarehouseLogic;
import classes.in.Input;
import classes.warehouse.Warehouse;

public class Main {
  public static void main(String[] args) {

    WarehouseLogic.createZone("bici",2,2);
    WarehouseLogic.createZone("bici",1,3);
    WarehouseLogic.createZone("bici",3,3);
    WarehouseLogic.productStockIn(0,"shampo","panthene","contro zecche e zanzare",3.22);
    WarehouseLogic.productStockIn(0,"shampo","panthene","contro zecche e zanzare",3.22);
    Warehouse.getAllPositions(1);
  }
}

