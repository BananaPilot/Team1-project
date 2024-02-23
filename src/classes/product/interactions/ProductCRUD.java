package classes.product.interactions;

import java.util.ArrayList;

import classes.database.DB;
import classes.position.Position;
import classes.product.Product;
import classes.zone.Zone;
import in.Input;
import classes.shared.Searchable;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import util.Util;

public class ProductCRUD {


    /**
     * requests an input for every attribute of a product and creates it, adding it to the products arraylist
     *
     * @since 0.1
     */
    public Product createProduct() {
        return new Product(
                Input.getString("Name: "),
                Input.getString("Brand: "),
                Input.getString("Description: "),
                Input.getInstance().getDouble("Price: "),
                (Supplier) Util.select(DB.getInstance().getSuppliers(), "Select a supplier: "),
                (ProductType) Util.select(DB.getInstance().getProductTypes(), "Select product type: "),
                (Position) Util.select(
                        ((Zone) Util.select(DB.getInstance().getZones(), "Select stocking zone: ")) //select zone of interest
                                .getPositions(), "Select stocking position:") //completing selection of position
        );
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
        input = Input.getInstance().getInput();
        Object object = switch (input) {
            case 1 -> Searchable.search(products, Input.getInstance().getString("ID: "));
            case 2 -> Searchable.search(products, Input.getInstance().getString("Name: "));
            case 3 -> Searchable.search(products, Input.getInstance().getString("Brand: "));
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
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> product.setName(Input.getInstance().getString("New name: "));
                case 2 -> product.setBrand(Input.getInstance().getString("New brand: "));
                case 3 -> product.setDescription(Input.getInstance().getString("New description: "));
                case 4 -> product.setPrice(Input.getInstance().getDouble("New price: "));
                case 5 -> product.setPosition((Position) Util.select(
                        ((Zone) Util.select(DB.getInstance().getZones(), "Select new stocking zone: ")) //select zone of interest
                                .getPositions(), "Select new stocking position:"));
            }
        } while (input != 0);
        System.out.println("Updated product: " + product);
    }

}