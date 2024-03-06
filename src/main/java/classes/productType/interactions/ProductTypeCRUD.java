package classes.productType.interactions;

import classes.database.DB;
import classes.productType.ProductType;
import classes.shared.Searchable;
import in.Input;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeCRUD {
    public ProductType createProductType() {
        return new ProductType(Input.getInstance().getString("Name of the product type: "), Input.getInstance().getString("Description: ") );
    }

    public void listProductTypes(List<ProductType> productTypes) {
        Util.printArrayList(productTypes);
    }

    public ProductType getProductType(List<ProductType> productTypes) {
        ProductTypePrompts.productTypeSearchPrompt();
        int input = Input.getInstance().getInput();
        return switch (input){
            case 1 -> Searchable.search(productTypes, Input.getInstance().getString("ID: "));
            case 2 -> Searchable.search(productTypes, Input.getInstance().getString("Name: "));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateProductType(List<ProductType> productTypes) {
        ProductType productType = getProductType(productTypes);
        if (productType == null) {
            return;
        }

        int input;
        do {
            ProductTypePrompts.productTypeUpdatePrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> productType.setName(Input.getInstance().getString("New name: "));
                case 2 -> productType.setDescription(Input.getInstance().getString("New description: "));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);

        System.out.println("Updated product type" + productType);
    }
}
