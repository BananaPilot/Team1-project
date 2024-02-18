package CRUD.product;

import java.util.ArrayList;

import classes.database.DB;
import in.Input;
import prompts.product.ProductPrompts;
import classes.shared.Searchable;
import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.*;
import util.Util;

public class ProductCRUD {


    /**
     * requests an input for every attribute of a product and creates it, adding it to the products arraylist
     *
     * @since 0.1
     */
    public Product createProduct() throws IllegalArgumentException{
        Product product;
        try {
            product = new Product(
                    Input.getString("Name: "),
                    Input.getString("Brand: "),
                    Input.getString("Description: "),
                    Input.getDouble("Price: "),
                    Util.select(DB.getInstance().getSuppliers(), "Select a supplier: "),
                    Util.select(DB.getInstance().getProductTypes(), "Select product type: "),
                    Util.select(
                            Util.select(DB.getInstance().getZones(), "Select stocking zone: ") //select zone of interest
                            .getPositions(),"Select stocking position:") //completing selection of position
            );
        } catch (IllegalArgumentException e) {
            product = null;
            e.getMessage();
        }
        if(product == null) {
            throw new IllegalArgumentException("Couldn't create product because of empty lists of suppliers, product types or stocking positions.");
        }
        return product;
    }

    /**
     * Iterates all products showing them to video
     *
     * @since 0.1
     */

    public void listAllProducts(ArrayList<Product> products) {
        Util.printArrayList(products);
    }


    /**
     * @param products     of products to search from
     * @param productTypes of product types to select from
     * @return arraylist with products with the selected type
     * @since 0.1
     */
    public ArrayList<Product> searchByProductType(ArrayList<Product> products, ArrayList<ProductType> productTypes) {
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
     * Searches for elements including the searched string
     *
     * @return the element(s) corresponding to the searched string
     * @see Searchable
     */

    public Product getProduct(ArrayList<Product> products) {
        int input;
        ProductPrompts.searchProductPrompt();
        input = Input.getInput();
        Object object = switch (input) {
            case 1 -> Searchable.search(products, Input.getString("ID: "));
            case 2 -> Searchable.search(products, Input.getString("Name: "));
            case 3 -> Searchable.search(products, Input.getString("Brand: "));
            case 4 -> searchByProductType(products, DB.getInstance().getProductTypes());
            default -> null;
        };
        assert object instanceof Product;
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

    public void updateProduct(ArrayList<Product> products) {
        Product product = getProduct(products);
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
                        ((Zone) Util.select(DB.getInstance().getZones(), "Select new stocking zone: ")) //select zone of interest
                                .getPositions(), "Select new stocking position:"));
            }
        } while (input != 0);
        System.out.println("Updated product: " + product);
    }

}