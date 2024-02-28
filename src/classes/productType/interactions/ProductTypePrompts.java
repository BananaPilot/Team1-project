package classes.productType.interactions;

public class ProductTypePrompts {
    public static void productTypeMainPrompt() {
        System.out.println("1. Create a new product type");
        System.out.println("2. List all product type");
        System.out.println("3. List a specific product type");
        System.out.println("4. Update a specific product type");
        System.out.println("5. Delete a product type");
        System.out.println("0. back to main menu");
    }

    public static void productTypeSearchPrompt() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by product type name");
        System.out.println("0. back to main menu");
    }

    public static  void productTypeUpdatePrompt() {
        System.out.println("1. Change name");
        System.out.println("2. Change description");
    }
}
