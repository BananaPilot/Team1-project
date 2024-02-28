package classes.productType.interactions;

import classes.database.DB;
import classes.productType.ProductType;
import in.Input;

import java.util.ArrayList;

public class ProductTypeInteractions {
    private final ProductTypeCRUD productTypeCRUD = new ProductTypeCRUD();
    private final ArrayList<ProductType> productTypes = DB.getInstance().getProductTypes();

    public void productTypeHandler() {
        int input;
        do {
            ProductTypePrompts.productTypeMainPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> productTypes.add(productTypeCRUD.createProductType());
                case 2 -> productTypeCRUD.listProductTypes(productTypes);
                case 3 -> System.out.println(productTypeCRUD.getProductType(productTypes));
                case 4 -> productTypeCRUD.updateProductType(productTypes);
                case 5 -> productTypes.remove(productTypeCRUD.getProductType(productTypes));
            }
        } while (input > 0);
    }
}
