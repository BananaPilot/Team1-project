import Logic.WarehouseLogic;
import classes.warehouse.Warehouse;

public class Main {
    public static void main(String[] args){

       WarehouseLogic.createZone("biciclette",3,3);
       WarehouseLogic.productStockIn(0,2,"shampo","zecche e zanzare","shampo de merda",3.99);
       Warehouse.getAllPositions(1);
       WarehouseLogic.searchByLot("1L0",1);


    }
}
