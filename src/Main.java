import Logic.WarehouseLogic;
import UserInput.UserInputWarehouse;
import classes.product.Product;
import classes.warehouse.Warehouse;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        WarehouseLogic.createZone("Giardinaggio",3,3);


        WarehouseLogic.stockingManagement(1,1,2,"Piantalons","LE MARGHERITINE MAGICHE","nikita piace",8);
        WarehouseLogic.stockingManagement(1,1,2,"Babaluitron","I VASI DI JACK","nikita piace",8);


        WarehouseLogic.restockProduct(1,"1L0","2L0");
        WarehouseLogic.checkFullPositions(1);

    }
}
