
import CRUD.product.ProductCRUD;
import classes.product.Product;
import in.Input;
import prompts.MainPrompt;
import prompts.productprompts.ProductsHandler;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
//		String input = null;
//		do {
//			MainPrompt.mainMenuPrompts();
//			input = Input.getScanner().nextLine();
//			try {
//				Integer.parseInt( input );
//			} catch (Exception e) {
//				System.out.println("Unexpected value: " + input);
//			}
//			switch (input) {
//			case "1": {
//				ProductsHandler.productsMainMenu();
//				break;
//			}
//			default:
//				System.out.println("Unexpected value: " + input);
//			}
//		} while (!input.equals("0"));
		Input.getScanner().close();
  	}
}

