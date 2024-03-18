package com.team1.app.classes.product.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.product.Product;
import com.team1.app.classes.in.In;
import com.team1.app.classes.shared.ExceptionHandler;

import java.util.List;

public class ProductInteractions {

    private final List<Product> products = DB.getInstance().getProducts();
    private final ProductCRUD productCRUD = new ProductCRUD();

    public void productsHandler() {
        int input;

        do {
            ProductPrompts.mainProductPrompt();
            input = In.getInstance().getInt("Input: ");
            try {
                switch (input) {
                    case 1 -> products.add(productCRUD.createProduct());
                    case 2 -> productCRUD.listAllProducts(products);
                    case 3 -> productCRUD.getProduct(products);
                    case 4 -> productCRUD.updateProduct(products);
                    case 5 -> products.remove(productCRUD.getProduct(products));
                    case 0 -> System.out.println("Going back");
                    default -> System.out.println("Unexpected value: " + input);
                }
            } catch (Exception e) {
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);

    }
}
