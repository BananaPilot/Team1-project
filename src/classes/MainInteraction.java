package classes;

import in.Input;
import classes.customer.inteactions.CustomerInteractions;
import classes.position.interactions.PositionInteractions;
import classes.product.interactions.ProductInteractions;
import classes.supplier.interactions.SupplierInteractions;
import classes.zone.interactions.ZoneInteractions;

public class MainInteraction {
    CustomerInteractions customerInteractions = new CustomerInteractions();
    SupplierInteractions supplierInteractions = new SupplierInteractions();
    ProductInteractions productInteractions = new ProductInteractions();

    //TODO prductType interactions
    ZoneInteractions zoneInteractions = new ZoneInteractions();
    PositionInteractions positionInteractions = new PositionInteractions();
    public void mainHandler() {
        int input;
        do {
            input = Input.getInput();
            MainPrompt.mainPrompt();
            switch (input) {
                case 1 -> customerInteractions.CustomerHandler();
                case 2 -> supplierInteractions.supplierHandler();
                case 3 -> productInteractions.productsHandler();
                case 4 -> System.out.println("todo");
                case 5 -> zoneInteractions.zoneHandler();
                case 6 -> positionInteractions.positionHandler();
            }
        } while (input != 0);
    }
}
