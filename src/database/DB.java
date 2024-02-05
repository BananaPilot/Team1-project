package database;

import java.util.ArrayList;
import java.util.Arrays;

import classes.warehouse.Position;
import classes.customer.Customer;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.Zone;

public class DB {

    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Supplier> suppliers = new ArrayList<Supplier>(Arrays.asList(
            new Supplier(null, null, 0, null, null, null),
            new Supplier(null, null, 0, null, null, null)
    ));
    private static ArrayList<ProductType> productTypes = new ArrayList<ProductType>(Arrays.asList(
            new ProductType(null, null)
    ));
    private static ArrayList<Zone> zones = new ArrayList<>();
    private static ArrayList<Customer> customers;


    public static ArrayList<Supplier> getSuppliers() {
        if (suppliers == null) {
            suppliers = new ArrayList<>();
        }
        return suppliers;
    }

    public static ArrayList<ProductType> getProductTypes() {
        if (productTypes == null) {
            productTypes = new ArrayList<>();
        }
        return productTypes;
    }

    public static ArrayList<Zone> getZones() {
        if (zones == null) {
            zones = new ArrayList<>();
        }
        return zones;
    }

    public static ArrayList<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public static ArrayList<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        return customers;
    }
}
