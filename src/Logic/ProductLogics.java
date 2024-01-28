package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import classes.in.Input;
import classes.product.Selector;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.StockPosition;

public class ProductLogics {
	private static ArrayList<Product> products = new ArrayList<Product>();
	public static ArrayList<Supplier> suppliers = new ArrayList<Supplier>(Arrays.asList(
			new Supplier(null, null, 0, null, null, null),
			new Supplier(null, null, 0, null, null, null)
			));
	public static ArrayList<ProductType> productTypes = new ArrayList<ProductType>(Arrays.asList(
			new ProductType(null, null)
			));
	public static ArrayList<StockPosition> stockPositions = new ArrayList<StockPosition>(Arrays.asList(
			new StockPosition()
			));
	
	public static void createProduct() {
		System.out.println("Insert product name: ");
		String name = Input.getString();
		System.out.println("Insert product brand: ");
		String brand = Input.getString();
		System.out.println("Insert product description");
		String description = Input.getString();
		System.out.println("Insert product price:");
		Double price = (double) Input.getDouble();
		//selectSupplier
		Supplier supplierID = Selector.selectAsset(suppliers, "Select a supplier:");
		//selectProductType
		ProductType productTypeID = Selector.selectAsset(productTypes, "Select product type:");
		//selectPosition
		StockPosition position = Selector.selectAsset(stockPositions, "Select stocking position:");
		products.add(new Product(name, brand, description, price, supplierID, productTypeID, position));
	}
	
	public static void listAllProducts(){
		int i = 1;
		for (Product product : products) {
			System.out.println(i + ". " + product);
			i++;
		}
	}
	
}
