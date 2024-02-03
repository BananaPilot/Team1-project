package prompts.productprompts;

import java.util.Optional;

import classes.in.Input;
import classes.product.Product;
import logic.product.ProductLogics;

public class ProductsHandler {
	public static void productsMainMenu() {
		String input = null;
		do {
			ProductPrompts.mainProductPrompt();
			input = Input.getScanner().nextLine();
			switch (input) {
			case "1": {
				ProductLogics.createProduct();
				break;
			}
			case "2": {
				ProductLogics.listAllProducts();
				break;
			}
			case "3": {
				ProductLogics.addProductTracking(ProductLogics.products);
				break;
			}
			case "4": {
				searchMenu();
				break;
				
			}
			case "0":{
				continue;
			}
			default:
				System.out.println("Unexpected value: " + input);
			}
		} while (!input.equals("0"));
	}
	private static void searchMenu() {
		String input = null;
		do {
			ProductPrompts.searchProductsPrompt();
			input = Input.getScanner().nextLine();
			try {
				Integer.parseInt( input );
			} catch (Exception e) {
				System.out.println("Unexpected value: " + input);
			}
			switch (input) {
			case "1": {
				ProductLogics.searchByID(ProductLogics.products);
				break;
			}
			case "2": {
				Optional<Product> optionalProduct = ProductLogics.searchByName(ProductLogics.products);
				optionalProduct.orElseThrow();
				if (optionalProduct.isEmpty()) {
					
				}else {
					
				}
				break;
			}
			case "3": {
				ProductLogics.searchByBrand(ProductLogics.products);
				break;
			}
			case "4":{
				ProductLogics.searchByProductType(ProductLogics.products,
												ProductLogics.productTypes);
			}
			case "0":{
				continue;
			}
			default:
				System.out.println("Unexpected value: " + input);
			}
		} while (!input.equals("0"));
	}
}
