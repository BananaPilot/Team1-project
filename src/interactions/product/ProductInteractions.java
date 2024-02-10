package interactions.product;

import CRUD.product.ProductCRUD;
import database.DB;
import in.Input;
import prompts.product.ProductPrompts;

public class ProductInteractions {
    public static void productsHandler() {
        int input;
        do {
            ProductPrompts.mainProductPrompt();
            input = Input.getInt(null);
            switch (input) {
                case 1 -> ProductCRUD.createProduct();
                case 2 -> ProductCRUD.listAllProducts();
                case 3 -> ProductCRUD.getProduct();
                case 4 -> DB.getProducts().remove(ProductCRUD.getProduct());
            }
        } while (input != 0);
    }
}
