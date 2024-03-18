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
        try{
            do {
                ProductPrompts.mainProductPrompt();
                input = In.getInstance().getInt("Input: ");
                switch (input) {
                    case 1 -> products.add(productCRUD.createProduct());
                    case 2 -> productCRUD.listAllProducts(products);
                    case 3 -> productCRUD.getProduct(products);
                    case 4 -> productCRUD.updateProduct(products);
                    case 5 -> products.remove(productCRUD.getProduct(products));
                    default -> System.out.println("Unexpected value: " + input);
                }
            } while (input != 0);
        }catch (Exception e){
            new ExceptionHandler().handle(e);
        }
    }
}
