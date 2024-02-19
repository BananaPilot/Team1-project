package interactions;

import in.Input;
import interactions.customer.CustomerInteractions;
import interactions.position.PositionInteractions;
import interactions.product.ProductInteractions;
import interactions.supplier.SupplierInteractions;
import interactions.zone.ZoneInteractions;
import prompts.MainPrompt;

public class MainInteraction {
    CustomerInteractions customerInteractions = new CustomerInteractions();
    SupplierInteractions supplierInteractions = new SupplierInteractions();
    ProductInteractions productInteractions = new ProductInteractions();

    //TODO productType interactions
    ZoneInteractions zoneInteractions = new ZoneInteractions();
    PositionInteractions positionInteractions = new PositionInteractions();
    public void mainHandler() {
        int input;
        do {
            MainPrompt.mainPrompt();
            input = Input.getInput();
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
