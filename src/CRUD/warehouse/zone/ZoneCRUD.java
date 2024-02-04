package CRUD.warehouse.zone;

import classes.product.Product;
import classes.warehouse.Position;
import classes.warehouse.Zone;

import java.util.ArrayList;

public class ZoneCRUD {
  public static Product searchByLot(String lot, int selectedZone) {
    selectedZone--;

    ArrayList<Position> sector = Zone.getWarehouseZones().get(selectedZone).getPositions();
    Product risultato = null;
    for (Position position : sector) {

      String firstComparison = convertLotFirst(position.getLot().toString());
      String secondComparison = convertLotSecond(position.getLot().toString());

      if ( convertLotFirst(lot).equalsIgnoreCase(firstComparison) && convertLotSecond(lot).equalsIgnoreCase(secondComparison)) {
        System.out.println(position.getProduct());
        System.out.println(position.getProduct().getPosition().getQuantity());
        risultato = position.getProduct();
      }
    }
    return risultato;
  }

  public static void deleteSector(int zone){
    zone--;
    Zone.getWarehouseZones().remove(zone);
  }
}
