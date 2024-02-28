package classes.product.interactions;

import classes.database.DB;
import classes.product.Product;
import in.Input;

import java.util.ArrayList;
import java.util.List;

public class ProductInteractions {

    private final List<Product> products = DB.getInstance().getProducts();
    private final ProductCRUD productCRUD = new ProductCRUD();
    public void productsHandler() {
        int input;
        do {
            ProductPrompts.mainProductPrompt();
            input = Input.getInstance().getInt(null);
            switch (input) {
                case 1 -> productCRUD.createProduct();
                case 2 -> productCRUD.listAllProducts(products);
                case 3 -> productCRUD.getProduct(products);
                case 4 -> products.remove(productCRUD.getProduct(products));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}
