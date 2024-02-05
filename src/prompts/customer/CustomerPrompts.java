package prompts.customer;

public class CustomerPrompts {
    public static void customerMainPrompt() {
        System.out.println("1. Create a new customer");
        System.out.println("2. List all customers");
        System.out.println("3. List a specific customer");
        System.out.println("4. Update a customer");
        System.out.println("5. Delete a customer");
        System.out.println("0. Back to main menu");
    }

    public static void customerSearchPrompt() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by E-mail");
        System.out.println("3. Search by name and surname");
        System.out.println("0. Back to previous menu");
    }

    public static void customerUpdatePrompt() {
        System.out.println("1. Change name");
        System.out.println("2. Change surname");
        System.out.println("3. Change address");
        System.out.println("4. Change E-mail");
        System.out.println("5. Change Phone-number");
        System.out.println("0. Back to previous menu");
    }
}
