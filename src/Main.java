import Logic.ProductLogics;
import classes.in.Input;
import prompts.productprompts.ProductPromtps;

public class Main {
	public static void main(String[] args) {
		String input = null;
		do {
			ProductPromtps.mainProductPrompt();
			input = Input.getString();
			try {
				Integer.parseInt( input );
			} catch (Exception e) {
				System.out.println("Unexpected value: " + input);
			}
			switch (input) {
			case "1": {
				ProductLogics.createProduct();
				break;
			}
			case "2": {
				ProductLogics.listAllProducts();
				break;
			}
			default:
				System.out.println("Unexpected value: " + input);
			}
		} while (!input.equals("0"));
		Input.getScanner().close();
  	}
}

