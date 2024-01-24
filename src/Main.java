import Logic.WarehouseLogic;
import UserInput.UserInputWarehouse;
import classes.product.Product;
import classes.warehouse.Warehouse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        WarehouseLogic.createZone("Giardinaggio",5,2);
        WarehouseLogic.createZone("Bicchierotron",4,2);
        WarehouseLogic.stockingManagement(1,1,2,"Vaso","Vaso maximum","Vaso per piante",4);
        WarehouseLogic.stockingManagement(1,1,3,"Rastrello","Il king dei rastrelli","ce rastrelli pure la santissima",0.99);

        WarehouseLogic.checkFullPositions(1);

        WarehouseLogic.checkEmptyPositions(1);
        Product pippo = WarehouseLogic.searchByLot("2L0",1);
        WarehouseLogic.checkWarehouses();
        UserInputWarehouse.mainWarehouseInput();

    }
}
