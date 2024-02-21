package classes.supplier.interactions;

public class SupplierPrompts {
    public static void supplierMainPrompt() {
        System.out.println("1. Create a new supplier");
        System.out.println("2. List all suppliers");
        System.out.println("3. List a specific supplier");
        System.out.println("4. Update a supplier");
        System.out.println("5. Delete a supplier");
        System.out.println("6. Select a supplier and manage orders");
        System.out.println("0. Back to main menu");
    }

    public static void supplierSearchPrompt() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by VAT-number");
        System.out.println("3. Search by email");
        System.out.println("4. Search by address");
        System.out.println("5. Search by company name");
        System.out.println("6. Search by supplied product type");
        System.out.println("0. Back to previous menu");
    }

    public static void supplierUpdatePrompt() {
        System.out.println("1. Update company name");
        System.out.println("2. Update VAT number");
        System.out.println("3. Update address");
        System.out.println("4. Update E-mail");
        System.out.println("5. Update Phone-number");
        System.out.println("0. Back to previous menu");
    }
}
