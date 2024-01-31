import classes.in.Input;
import logic.product.ProductLogics;
import prompts.MainPrompt;
import prompts.productprompts.ProductPrompts;
import prompts.productprompts.ProductsHandler;

public class Main {
	public static void main(String[] args) {
		String input = null;
		do {
			MainPrompt.mainMenuPrompts();
			input = Input.getString();
			try {
				Integer.parseInt( input );
			} catch (Exception e) {
				System.out.println("Unexpected value: " + input);
			}
			switch (input) {
			case "1": {
				ProductsHandler.productsMainMenu();
				break;
			}
			default:
				System.out.println("Unexpected value: " + input);
			}
		} while (!input.equals("0"));
		Input.getScanner().close();
  	}
}

