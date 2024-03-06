package com.team1.app.classes.product.interactions;

import java.util.ArrayList;
import java.util.List;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.product.Product;
import com.team1.app.classes.in.Input;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.productType.ProductType;
import com.team1.app.classes.util.Util;

public class ProductCRUD {


    /**
     * requests an input for every attribute of a product and creates it, adding it to the products arraylist
     *
     * @since 0.1
     */
    public Product createProduct() {
        return new Product(
                Input.getInstance().getString("Name: "),
                Input.getInstance().getString("Brand: "),
                Input.getInstance().getString("Description: "),
                Input.getInstance().getDouble("Price: "),
                Util.select(DB.getInstance().getSuppliers(), "Select a supplier: "),
                Util.select(DB.getInstance().getProductTypes(), "Select product type: "),
                Util.select(
                        (Util.select(DB.getInstance().getZones(), "Select stocking zone: ")) //select zone of interest
                                .getPositions(), "Select stocking position:") //completing selection of position
        );
    }

    /**
     * Iterates all products showing them to video
     *
     * @since 0.1
     */

    public void listAllProducts(List<Product> products) {
        Util.printArrayList(products);
    }


    /**
     * @param products     of products to search from
     * @param productTypes of product types to select from
     * @return arraylist with products with the selected type
     * @since 0.1
     */
    public List<Product> searchByProductType(List<Product> products, List<ProductType> productTypes) {
        Util.printArrayList(productTypes);
        ProductType productType = ProductType.search(productTypes, Input.getInstance().getString("Type name: "));
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

    public Product getProduct(List<Product> products) {
        int input;
        ProductPrompts.searchProductPrompt();
        input = Input.getInstance().getInput();
        Object object = switch (input) {
            case 1 -> Searchable.search(products, Input.getInstance().getString("ID: "));
            case 2 -> Searchable.search(products, Input.getInstance().getString("Name: "));
            case 3 -> Searchable.search(products, Input.getInstance().getString("Brand: "));
            case 4 -> searchByProductType(products, DB.getInstance().getProductTypes());
            default -> throw new IllegalStateException("Unexpected value: " + input);
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

    public void updateProduct(List<Product> products) {
        Product product = getProduct(products);
        if (product == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            ProductPrompts.updateProductPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> product.setName(Input.getInstance().getString("New name: "));
                case 2 -> product.setBrand(Input.getInstance().getString("New brand: "));
                case 3 -> product.setDescription(Input.getInstance().getString("New description: "));
                case 4 -> product.setPrice(Input.getInstance().getDouble("New price: "));
                case 5 -> product.setPosition(Util.select((Util.select(DB.getInstance().getZones(), "Select new stocking zone: ")) //select zone of interest
                                .getPositions(), "Select new stocking position:"));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
        System.out.println("Updated product: " + product);
    }

}