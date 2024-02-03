import CRUD.warehouse.WarehouseCRUD;
import interactions.warehouse.Logic.WarehouseLogic;

public class Main {

    public static void main(String[] args){


        WarehouseCRUD.createWarehouseSector();


        WarehouseLogic.stockingManagement(1,1,2,"Piantalons","LE MARGHERITINE MAGICHE","nikita piace",8);
        WarehouseLogic.stockingManagement(1,1,2,"Babaluitron","I VASI DI JACK","nikita piace",8);
        WarehouseCRUD.mainWarehouseCRUD();
        WarehouseLogic.checkWarehouses();

    }
}
