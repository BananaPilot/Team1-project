package prompts.supplier.order;

public class SupplierOrderPrompts {
    public static void supplierOrderMainPrompt(){
        System.out.println("1. Create order");
        System.out.println("2. List orders");
        System.out.println("3. Search order");
        System.out.println("4. Update order");
        System.out.println("5. Delete order");
        System.out.println("0. Back to main menu");
    }

    public static void supplierOrderSearchPrompt() {
        System.out.println("1. Search by order holder");
        System.out.println("2. Search by order ID");
        System.out.println("3. Search by date");
        System.out.println("0. Back to previous menu");
    }

    public static void supplierOrderUpdatePrompt() {
        System.out.println("1. Update order holder");
        System.out.println("2. Update order products");
        System.out.println("0. Back to previous menu");
    }

    public static void supplierOrderDeletePrompt() {
        System.out.println("1. Delete order");
        System.out.println("0. Back to previous menu");
    }
}
