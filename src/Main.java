import Logic.WarehouseLogic;
import classes.warehouse.Warehouse;

public class Main {
    public static void main(String[] args){

        WarehouseLogic.createZone("biciclette",3,3);
        WarehouseLogic.stockingManagement(2,1,2,"shampoo","panthene","zecche e zanzare",2.55);
        WarehouseLogic.stockingManagement(2,1,3,"bicicletta","jack bycycle","zecche e zanzare",2.55);


        WarehouseLogic.searchByName("bicicletta","jack bycycle",1);
    }
}
