package prompts.productprompts;

public class ProductPrompts {
	protected static void mainProductPrompt() {
		System.out.println("1. Create new product");
		System.out.println("2. List all products");
		System.out.println("3. Add tracking to a product...");
		System.out.println("4. Search for products");
		System.out.println("5. Modify products");
		System.out.println("6. Delete products");
		System.out.println("0. Previous menu...");
	}
	
	protected static void searchProductsPrompt() {
		System.out.println("1. Search product by ID");
		System.out.println("2. Search product by name");
		System.out.println("3. Search products by brand");
		System.out.println("4. Search products by type");
		System.out.println("5. Search products by stocking date");
		System.out.println("0. Previous menu...");
	}
	
	protected void modifyProductsPrompts() {
		//TODO
	}
	
	protected void deleteProductsPrompts() {
		//TODO
	}
}
