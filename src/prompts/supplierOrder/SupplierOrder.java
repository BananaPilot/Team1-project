package prompts.supplierOrder;

public class SupplierOrder {
    public static void mainPrompt(){
        System.out.println("Supplier Order Managment Software");
        System.out.println("1. Create a new Order");
        System.out.println("2. See exsisting Orders");
        System.out.println("3. Modify an Order");
        System.out.println("4. Delete an Order");
        System.out.println("0. Exit the Program");
        System.out.println("Input: ");
    }

    public static void orderCreationPrompt(){
        System.out.println("1. Search products by name");
        System.out.println("2. Search product by UUID");
        System.out.println("0. Back to main menu");
        System.out.println("Input: ");
    }
    public static void orderListPrompt(){
        System.out.println("1. Show latest order");
        System.out.println("2. Show full history");
        System.out.println("0. Back to main menu");
        System.out.println("Input: ");
    }
    public static void orderModifyPrompt(){
        System.out.println("1. Modify product");
        System.out.println("2. Modify delivery date");
        System.out.println("3. Modify order quantity");
        System.out.println("0. Back to main menu");
        System.out.println("Input: ");
    }
    public static void orderDeletePrompt(){
        System.out.println("1. Delete last order");
        System.out.println("2. Delete all orders");
        System.out.println("0. Back to main menu");
        System.out.println("Input: ");
    }
}
