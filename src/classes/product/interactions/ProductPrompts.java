package classes.product.interactions;

public class ProductPrompts {
    public static void mainProductPrompt() {
        System.out.println("1. Create new product");
        System.out.println("2. List all products");
        System.out.println("3. Search for products");
        System.out.println("4. Delete products");
        System.out.println("0. Previous menu...");
    }

    public static void searchProductPrompt() {
        System.out.println("1. Search product by ID");
        System.out.println("2. Search product by name");
        System.out.println("3. Search product by brand");
        System.out.println("4. Search products by type");
        System.out.println("0. Previous menu...");
    }

    public static void updateProductPrompt() {
        System.out.println("1. Change name");
        System.out.println("2. Change brand");
        System.out.println("3. Change description");
        System.out.println("4. Change price");
        System.out.println("5. Select new stocking position...");
        System.out.println("0. Back to previous menu");
    }

    public static void deleteProductNaPrompts() {
        //TODO
    }
}
