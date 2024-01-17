import classes.in.Input;
import classes.warehouse.Warehouse;

public class Main {
  public static void main(String[] args) {

    Warehouse.createZone("bici",2,2);
    Warehouse.createZone("bici",1,1);
    Warehouse.createZone("bici",3,8);
    Warehouse.getAllPositions(1);
    Warehouse.getAllPositions(2);
    Warehouse.getAllPositions(3);
  }
}

