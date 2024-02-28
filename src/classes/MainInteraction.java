package classes;

import classes.productType.interactions.ProductTypeInteractions;
import classes.shared.ExceptionHandler;
import in.Input;
import classes.customer.inteactions.CustomerInteractions;
import classes.position.interactions.PositionInteractions;
import classes.product.interactions.ProductInteractions;
import classes.supplier.interactions.SupplierInteractions;
import classes.zone.interactions.ZoneInteractions;

import java.util.concurrent.TimeUnit;

public class MainInteraction {
    CustomerInteractions customerInteractions = new CustomerInteractions();
    SupplierInteractions supplierInteractions = new SupplierInteractions();
    ProductInteractions productInteractions = new ProductInteractions();
    ProductTypeInteractions productTypeInteractions = new ProductTypeInteractions();
    ZoneInteractions zoneInteractions = new ZoneInteractions();
    PositionInteractions positionInteractions = new PositionInteractions();
    public void mainHandler() throws InterruptedException {
        int input;
        do {
            TimeUnit.MILLISECONDS.sleep(200);
            MainPrompt.mainPrompt();
            input = Input.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> customerInteractions.CustomerHandler();
                    case 2 -> supplierInteractions.supplierHandler();
                    case 3 -> productInteractions.productsHandler();
                    case 4 -> productTypeInteractions.productTypeHandler();
                    case 5 -> zoneInteractions.zoneHandler();
                    case 6 -> positionInteractions.positionHandler();
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                }
            } catch (Exception e){
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);
    }
}
