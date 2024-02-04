package interactions.warehouse;
import in.Input;
import classes.warehouse.*;
import database.DB;
import prompts.warehouse.WarehousePrompts;


public class WarehouseInteractions {

    public static void createWarehouseSector(){
        CRUD.warehouse.WarehouseCRUD.createZone(Input.getString("Sector name"), Input.getInt("Zone width: "), Input.getInt("Zone height: "));
    }
    public static void checkAllSectors(){
        CRUD.warehouse.WarehouseCRUD.checkWarehouses();
    }
    public static Zone selectASector(int index){
        index--;
        return DB.getWarehouseZones().get(index);
    }
    public static void mainWarehouseCRUD(){

        int userInput;
        do{
            WarehousePrompts.warehouseMainPrompt();
            userInput = Input.getInput();
            switch (userInput){
                case 1 -> createWarehouseSector();
                case 2 -> {checkAllSectors(); selectedWarehouseCRUD(selectASector(Input.getInt("Sector: ")));}
            }
        } while (userInput > 0);
    }
    public static void selectedWarehouseCRUD(Zone selectedZone){
        System.out.println(selectedZone);
    }

}
