package CRUD.product;

import java.util.ArrayList;

import in.Input;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.*;
import database.DB;
import util.Util;

public class ProductCRUD {


    /**
     * requests an input for every attribute of a product and creates it, adding it to the products arraylist
     *
     * @since 0.1
     */
    public static Product createProduct() {
		return new Product(
        		Input.getString("Name: "),
        		Input.getString("Brand: "), 
        		Input.getString("Description: "), 
        		Input.getDouble("Price: "),
        		(Supplier) Util.select(DB.getSuppliers(),"Select a supplier: "),
        		(ProductType) Util.select(DB.getProductTypes(), "Select product type: "),
        		(Position) Util.select(
        				((Zone)Util.select(DB.getZones(), "Select stocking zone: ")) //select zone of interest
        				.getPositions(),"Select stocking position:") //completing selection of position
        		);
    }

    /**
     * Iterates all products showing them to video
     *
     * @since 0.1
     */
    public static void listAllProducts() {
        Util.printArrayList(DB.getProducts());
    }

    /**
     * @param products     of products to search from
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
        for (Product product : products) {
            if (product.contains(values)) return product;
        }
        return null;
    }
    
    public static void deleteProduct(ArrayList<Product> products) {
    	
    }
    
}