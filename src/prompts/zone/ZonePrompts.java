package prompts.zone;

public class ZonePrompts {
    public static void zoneMainPrompt(){
        System.out.println("1. Create zone");
        System.out.println("2. List all zones");
        System.out.println("3. List a specific zone");
        System.out.println("4. Update a zone");
        System.out.println("5. Delete a zone");
        System.out.println("0. Back to main menu");
    }

    public static void zoneSearchPrompt(){
        System.out.println("1. Search by Sector name");
    }

    public static void zoneUpdatePrompt(){
        System.out.println("1. Update Sector name");
    }
}