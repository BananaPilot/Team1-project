package classes.database;

import classes.customer.Customer;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;

import java.util.ArrayList;

public class DB {

    private static ArrayList<Product> products;
    private static ArrayList<Supplier> suppliers;
    private static ArrayList<ProductType> productTypes;
//        private static ArrayList<Zone> zones;
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

//        public static ArrayList<Zone> getZones() {
//            if (zones == null) {
//                zones = new ArrayList<>();
//            }
//            return zones;
//        }

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
