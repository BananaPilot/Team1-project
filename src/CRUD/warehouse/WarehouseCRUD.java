package CRUD.warehouse;
import classes.in.Input;
import classes.warehouse.*;
import interactions.warehouse.Logic.WarehouseLogic;
import prompts.warehouse.WarehousePrompts;


public class WarehouseCRUD {

    public static void createWarehouseSector(){
        WarehouseLogic.createZone(Input.getString("Sector name"), Input.getInt(), Input.getInt());
    }
    public static void checkAllSectors(){
        WarehouseLogic.checkWarehouses();
    }
    public static Zone selectASector(int index){
        index--;
        return Warehouse.getWarehouseZones().get(index);
    }
    public static void mainWarehouseCRUD(){

        int userInput;
        do{
            WarehousePrompts.warehouseMainPrompt();
            userInput = Input.getInt();
        switch (userInput){
            case 1 -> createWarehouseSector();
            case 2 -> {checkAllSectors(); selectedWarehouseCRUD(selectASector(Input.getInt()));}
        }
        }
        while (userInput > 0);
    }
    public static void selectedWarehouseCRUD(Zone selectedZone){
        System.out.println(selectedZone);
    }

}
