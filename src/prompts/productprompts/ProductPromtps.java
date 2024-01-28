package prompts.productprompts;

public class ProductPromtps {
	public static void mainProductPrompt() {
		System.out.println("1. Create new product");
		System.out.println("2. List all products");
		System.out.println("3. Search for products");
		System.out.println("4. Modify products");
		System.out.println("5. Delete products");
		System.out.println("0. Previous menu...");
	}
	
	public void createProductPrompt(Integer index) {
		
	}
	
	public static void searchForProductsPrompts() {
		System.out.println("Search by;");
		System.out.println("1. ID.");
		System.out.println("2. Name.");
		System.out.println("3. Brand.");
		System.out.println("4. Supplier.");
		System.out.println("5. Stocking date.");
		System.out.println("6. Product Type.");
	}
	
	public void modifyProductsPrompts() {
		//TODO
	}
	
	public void deleteProductsPrompts() {
		//TODO
	}
}
