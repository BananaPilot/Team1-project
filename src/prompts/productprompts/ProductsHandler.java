package prompts.productprompts;

import java.util.Optional;

import CRUD.product.ProductCRUD;
import in.Input;
import classes.product.Product;

public class ProductsHandler {
	public static void productsMainMenu() {
		String input = null;
		do {
			ProductPrompts.mainProductPrompt();
			input = Input.getScanner().nextLine();
			switch (input) {
			case "1": {
				ProductCRUD.createProduct();
				break;
			}
			case "2": {
				ProductCRUD.listAllProducts();
				break;
			}
			case "3": {
				ProductCRUD.addProductTracking(ProductCRUD.products);
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
				ProductCRUD.searchByID(ProductCRUD.products);
				break;
			}
			case "2": {
				Optional<Product> optionalProduct = ProductCRUD.searchByName(ProductCRUD.products);
				optionalProduct.orElseThrow();
				if (optionalProduct.isEmpty()) {
					
				}else {
					
				}
				break;
			}
			case "3": {
				ProductCRUD.searchByBrand(ProductCRUD.products);
				break;
			}
			case "4":{
				ProductCRUD.searchByProductType(ProductCRUD.products,
												ProductCRUD.productTypes);
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
