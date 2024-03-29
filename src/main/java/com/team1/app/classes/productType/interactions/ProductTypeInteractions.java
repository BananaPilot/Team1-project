package com.team1.app.classes.productType.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.productType.ProductType;
import com.team1.app.classes.in.In;
import com.team1.app.classes.shared.ExceptionHandler;

import java.util.List;

public class ProductTypeInteractions {
    private final ProductTypeCRUD productTypeCRUD = new ProductTypeCRUD();
    private final List<ProductType> productTypes = DB.getInstance().getProductTypes();

    public void productTypeHandler() {
        int input;

        do {
            ProductTypePrompts.productTypeMainPrompt();
            input = In.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> productTypes.add(productTypeCRUD.createProductType());
                    case 2 -> productTypeCRUD.listProductTypes(productTypes);
                    case 3 -> System.out.println(productTypeCRUD.getProductType(productTypes));
                    case 4 -> productTypeCRUD.updateProductType(productTypes);
                    case 5 -> productTypes.remove(productTypeCRUD.getProductType(productTypes));
                    case 0 -> System.out.println("Going back");
                    default -> System.out.println("Unexpected value: " + input);
                }
            } catch (Exception e) {
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);

    }
}
