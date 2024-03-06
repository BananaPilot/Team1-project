package classes.order.interactions;

public class OrderPrompts {
    private OrderPrompts() {}
    public static void orderMainPrompt() {
        System.out.println("1. Create a new supplier order");
        System.out.println("2. List all orders of a supplier");
        System.out.println("3. List a specific order of a supplier");
        System.out.println("4. Update order");
        System.out.println("5. Delete order");
        System.out.println("0. Back to main menu");
    }

    public static void orderCreationPrompt() {
        System.out.println("1. Select a product and add it to the order");
        System.out.println("2. Create a new product and add it to the order");
        System.out.println("0. to confirm the creation");
    }

    public static void orderSearchPrompt() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by date");
        System.out.println("0. Back to main menu");
    }

    public static void orderUpdatePrompt() {
        System.out.println("1. Update quantity");
        System.out.println("2. Update product");
        System.out.println("0. Back to previous menu");
    }
}
