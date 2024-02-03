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
				searchMenu();
				break;
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
				ProductCRUD.search(ProductCRUD.products, Input.getString("ID: "));
				break;
			}
			case "2": {
				ProductCRUD.search(ProductCRUD.products, Input.getString("Name: "));
				break;
			}
			case "3": {
				ProductCRUD.search(ProductCRUD.products, Input.getString("Brand: "));
				break;
			}
			case "4":{
				ProductCRUD.searchByProductType(ProductCRUD.products,
												ProductCRUD.productTypes);
			}
			default:
				System.out.println("Unexpected value: " + input);
			}
		} while (!input.equals("0"));
	}
}
