package UserInput;

import java.util.Scanner;

import Logic.WarehouseLogic;
import prompts.*;
import classes.warehouse.*;


public class UserInputWarehouse {

    private static Scanner input = new Scanner(System.in);

    public static void mainWarehouseInput(){


        String inputStr;
        do{
        WarehousePrompts.warehouseMainPrompt();
        Scanner input = UserInputWarehouse.getInput();
        inputStr = input.nextLine();
        switch (inputStr){
            case "1":
                WarehouseLogic.createZone("giardini",3,3);
                break;
            case "2":
                WarehouseLogic.checkWarehouses();
                System.out.println("seleziona settore: ");
                int index = input.nextInt();
                input.nextLine();
                Zone selectedZone = chooseWarehouse(index);
                warehouseSearchInput(selectedZone);
                break;

        }
        } while (!inputStr.equalsIgnoreCase("0"));
    }
    public static void warehouseSearchInput(Zone sector){
        System.out.println("Eseguire ricerca? \n " +
                               "Y or N");
        Scanner input = UserInputWarehouse.getInput();
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("Y")){
            int selectedZone = sector.getWarehouseIndex();
            do{
                WarehousePrompts.warehouseSearchPrompt();
                choice = input.nextLine();
                switch (choice){
                    case "1":
                        System.out.println("Nome: ");
                        String name = input.nextLine();
                        System.out.println("Brand: ");
                        String brand = input.nextLine();
                        WarehouseLogic.searchByName(name,brand,selectedZone);
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "0":
                        break;
                }
            } while (!choice.equalsIgnoreCase("0"));
        }


    }

  public static Zone chooseWarehouse(int index){
        Zone chosedSector = null;
        for (Zone settore : Zone.getWarehouseZones()){
            if (settore.getWarehouseIndex() == index){
                chosedSector = settore;
                System.out.println("Selected: " + settore);
            }
        }
        return chosedSector;
  }

    public static Scanner getInput() {
        return input;
    }
}
