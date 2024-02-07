package interactions.product;

import java.util.Optional;

import CRUD.product.ProductCRUD;
import classes.product.Product;
import database.DB;
import in.Input;
import prompts.productprompts.ProductPrompts;

public class ProductInteractions {
    public static void productsHandler() {
        int input;
        do {
            ProductPrompts.mainProductPrompt();
            input = Input.getInt(null);
            switch (input) {
                case 1 -> ProductCRUD.createProduct();
                case 2 -> ProductCRUD.listAllProducts();
                case 4 -> searchMenu(input);
                case 0 -> DB.getProducts().remove(null);
            }
        } while (input != 0);

    }

    private static void searchMenu(int input) {
        do {
            ProductPrompts.searchProductsPrompt();
            input = Input.getInt();
            switch (input) {
                case 1: {
                    ProductCRUD.search();
                    break;
                }
                case 2: {
                    ProductCRUD.search(ProductCRUD.products);
                }
                case 3: {
                    ProductCRUD.search(ProductCRUD.products);
                    break;
                }
                case 4: {
                    ProductCRUD.searchByProductType(ProductCRUD.products,
                            ProductCRUD.productTypes);
                }
            }
        } while (input != 0);
    }
}
