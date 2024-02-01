import Logic.WarehouseLogic;

public class Main {

    public static void main(String[] args){


        WarehouseLogic.createZone("Giardinaggio",3,3);

        WarehouseLogic.stockingManagement(1,1,2,"Piantalons","LE MARGHERITINE MAGICHE","nikita piace",8);
        WarehouseLogic.stockingManagement(1,1,2,"Babaluitron","I VASI DI JACK","nikita piace",8);

        WarehouseLogic.checkPositions(1);
        WarehouseLogic.restockProduct(1,"3L0","1L0");
        WarehouseLogic.checkPositions(1);

    }
}
