package CRUD.product;

import java.util.ArrayList;
import java.util.Arrays;

import in.Input;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.StockPosition;
import util.Util;

public class ProductCRUD {


	/**
	 * requests an input for every attribute of a product and creates it, adding it to the products arraylist
	 *
	 * @since 0.1
	 */
	public static Product createProduct() {
		return new Product(Input.getString("Name: "), Input.getString("Brand: "), Input.getString("Description: "), Input.getDouble("Price: "), (Supplier) Util.select(suppliers, "Select a supplier: "), (ProductType) Util.select(productTypes, "Select product type: "), (StockPosition) Util.select(stockPositions, "Select stocking position:"));
	}

	/**
	 * iterates all products showing them to video
	 *
	 * @since 0.1
	 */
	public static void listAllProducts() {
		Util.printArrayList(products);
	}

	/**
	 * @param products of products to search from
	 * @param productTypes of product types to select from
	 * @return arraylist with products with the selected type
	 * @since 0.1
	 */
	public static ArrayList<Product> searchByProductType(ArrayList<Product> products, ArrayList<ProductType> productTypes) {
		Util.printArrayList(productTypes);
		ProductType productType = ProductType.search(productTypes, Input.getString("ID: "));
		ArrayList<Product> productsByType = new ArrayList<Product>();
		for (Product product : products) {
			if (product.contains(productType)) {
				productsByType.add(product);
			}
		}
		return productsByType;
	}

	public static Product search(ArrayList<Product> products, Object... values) {
		for (Product product: products){
			if (product.contains(values)) return product;
		}
		return null;
	}
}