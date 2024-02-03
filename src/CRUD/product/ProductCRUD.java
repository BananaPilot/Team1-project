package CRUD.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import in.Input;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.StockPosition;
import logic.ElementSelector;

public class ProductCRUD {
	public static ArrayList<Product> products = new ArrayList<Product>();
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
	/**
	 *requests an input for every attribute of a product and creates it, adding it to the products arraylist
	 * @since 0.1
	 */
		public static void createProduct() {
		System.out.println("Insert product name: ");
		String name = Input.getScanner().nextLine();
		System.out.println("Insert product brand: ");
		String brand = Input.getScanner().nextLine();
		System.out.println("Insert product description:");
		String description = Input.getScanner().nextLine();
		System.out.println("Insert product price:");
		Double price = Input.getDouble();
		//selectSupplier
		Supplier supplierID = ElementSelector.selectAsset(suppliers, "Select a supplier:");
		//selectProductType
		ProductType productTypeID = ElementSelector.selectAsset(productTypes, "Select product type:");
		//selectPosition
		StockPosition position = ElementSelector.selectAsset(stockPositions, "Select stocking position:");
		products.add(new Product(name, brand, description, price, supplierID, productTypeID, position));
	}
	
	/**
	 * iterates all products showing them to video
	 * @since 0.1
	 */
	public static void listAllProducts(){
		int i = 1;
		for (Product product : products) {
			System.out.println(i + ". " + product);
			i++;
		}
	}
	
	/**
	 * @param Arraylist of products to search from
	 * requeststhe ID to search
	 * @return the product of the requested ID. if none is found, returns a null Product
	 * @since 0.1
	 */
	public static Product searchByID(ArrayList<Product> products) {
		System.out.println("Insert ID of the product to search:");
		String UUID = Input.getScanner().nextLine();
		for (Product product : products) {
			if(product.getID().equals(UUID)) {
				return product;
			}
		}
		return null;
	}
	
	/**
	 * @param Arraylist of products to search from
	 * requests the brand to search
	 * @return an array list of the products with the specified brand
	 * @since 0.1
	 */
	public static ArrayList<Product> searchByBrand(ArrayList<Product> products) {
		System.out.println("Insert the brand to search:");
		String brand = Input.getScanner().nextLine();
		ArrayList<Product> productsByBrand = new ArrayList<Product>();
		for (Product product : products) {
			if(product.getBrand().equals(brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
	}
	/**
	 * @param Arraylist of products to search from
	 * requests the name to search
	 * @return the product with the specified name. if none is found, returns a null Product
	 * @since 0.1
	 * 
	 */
	public static Optional<Product> searchByName(ArrayList<Product> products) {
		System.out.println("Insert the name to search:");
		String name = Input.getScanner().nextLine();
		for (Product product : products) {
			if(product.getName().equals(name)) {
				return Optional.of(product);
			}
		}
		return Optional.empty();
	}
	/**
	 * @param Arraylist of products to search from
	 * @param Arraylist of product types to select from
	 * @return arraylist with products with the selected type
	 * @since 0.1
	 */
	public static ArrayList<Product> searchByProductType(ArrayList<Product> products,
											ArrayList<ProductType> productTypes) {
		ProductType productType = ElementSelector.selectAsset(productTypes, "Select the type of the product:");
		ArrayList<Product> productsByType = new ArrayList<Product>(); 
		for (Product product : products) {
			if(product.getProductTypeID().equals(productType)) {
				productsByType.add(product);
			}
		}
		return productsByType;
	}
	
	/**
	 * 
	 * @param products list of products from which to select a product and add a productTracking to it
	 * @since 0.1
	 */
	public static void addProductTracking(ArrayList<Product> products) {
		Product product = ElementSelector.selectAsset(products, "Seleziona prodotto al quale aggiungere un movimento:");
		System.out.println("Quantità del prodotto in entrata:");
		Integer in = Integer.parseInt(Input.getScanner().nextLine()); //TODO try-catch
		System.out.println("Quantità del prodotto in uscita:");
		Integer out = Integer.parseInt(Input.getScanner().nextLine()); //TODO try-catch
		System.out.println("Quantità del prodotto in smaltimento:");
		Integer disposedOf = Integer.parseInt(Input.getScanner().nextLine()); //TODO try-catch
		product.addProductTracking(in, out, disposedOf);
	}
	
}