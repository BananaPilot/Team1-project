package prompts;

public class WarehousePrompts {
    public static void warehouseMainPrompt(){
        System.out.println(
                "1: Crea settore \n" +
                "2: Cerca settore \n" +
                "3: Cancella settore \n" +
                "0: Esci dal programma"
        );
    }
    public static void warehouseSearchPrompt(){
        System.out.println(
                "1: Cerca per nome e brand \n" +
                "2: Cerca per lotto \n" +
                "3: Cerca per ID prodotto"
        );
    }
}
