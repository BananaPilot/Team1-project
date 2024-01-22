import Logic.WarehouseLogic;
import classes.warehouse.Warehouse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        WarehouseLogic.createZone("biciclette",3,3);
        WarehouseLogic.stockingManagement(2,1,2,"shampoo","panthene","zecche e zanzare",2.55);
        WarehouseLogic.stockingManagement(2,1,3,"bicicletta","jack bycycle","zecche e zanzare",2.55);


        WarehouseLogic.checkFullPositions(1);
        WarehouseLogic.checkEmptyPositions(1);
    }
}
