package CRUD.product;

import java.util.ArrayList;

import in.Input;
import prompts.product.ProductPrompts;
import classes.interfaces.Searchable;
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
     * 
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
        ProductType productType = ProductType.search(productTypes, Input.getString("Type name: "));
        ArrayList<Product> productsByType = new ArrayList<Product>();
        for (Product product : products) {
            if (product.contains(productType)) {
                productsByType.add(product);
            }
        }
        return productsByType;
    }
    
    /**
     * 
     * @param products
     * @param values
     * @return 
     * @since 0.1
     */
    
    public static Product search(ArrayList<Product> products, Object... values) {
        for (Product product : products) {
            if (product.contains(values)) return product;
        }
        return null;
    }
    
    /**
     * Searches for elements including the searched string
     * 
     * @see Searchable
     * 
     * @return the element(s) corresponding to the searched string
     */
    
    public static Product getProduct() {
    	int input;
        ProductPrompts.searchProductPrompt();
        input = Input.getInput();
        Object object = switch (input) {
            case 1 -> search(DB.getProducts(), Input.getString("ID: "));
            case 2 -> search(DB.getProducts(), Input.getString("Name: "));
            case 3 -> search(DB.getProducts(), Input.getString("Brand: "));
            case 4 -> searchByProductType(DB.getProducts(), DB.getProductTypes());
            default -> null;
        };
        return (Product) object;
    }
    
    /**
     * Method used to update values of a Product instance:
     * Name
     * Brand
     * Description
     * Price
     * Position
     * 
     * @since 0.1
     */
    
    public static void updateProduct() {
        Product product = getProduct();
        if (product == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            ProductPrompts.updateProductPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> product.setName(Input.getString("New name: "));
                case 2 -> product.setBrand(Input.getString("New brand: "));
                case 3 -> product.setDescription(Input.getString("New description: "));
                case 4 -> product.setPrice(Input.getDouble("New price: "));
                case 5 -> product.setPosition((Position) Util.select(
        				((Zone)Util.select(DB.getZones(), "Select new stocking zone: ")) //select zone of interest
        				.getPositions(),"Select new stocking position:"));
            }
        } while (input != 0);
        System.out.println("Updated product: " + product);
    }
    
}