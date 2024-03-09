package com.team1.app.classes;

import com.team1.app.classes.productType.interactions.ProductTypeInteractions;
import com.team1.app.classes.shared.ExceptionHandler;
import com.team1.app.classes.in.In;
import com.team1.app.classes.customer.inteactions.CustomerInteractions;
import com.team1.app.classes.position.interactions.PositionInteractions;
import com.team1.app.classes.product.interactions.ProductInteractions;
import com.team1.app.classes.supplier.interactions.SupplierInteractions;
import com.team1.app.classes.zone.interactions.ZoneInteractions;

import java.util.concurrent.TimeUnit;

public class MainInteraction {
    CustomerInteractions customerInteractions = new CustomerInteractions();
    SupplierInteractions supplierInteractions = new SupplierInteractions();
    ProductInteractions productInteractions = new ProductInteractions();
    ProductTypeInteractions productTypeInteractions = new ProductTypeInteractions();
    ZoneInteractions zoneInteractions = new ZoneInteractions();
    PositionInteractions positionInteractions = new PositionInteractions();
    public void mainHandler() {
        int input;
        do {
            MainPrompt.mainPrompt();
            input = In.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> customerInteractions.customerHandler();
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
        } while (input > 0);
    }
}
