package classes.database;

import classes.customer.Customer;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.zone.Zone;

import java.util.ArrayList;

public class DB {

    private static DB db;
    private ArrayList<Product> products;
    private ArrayList<Supplier> suppliers;
    private ArrayList<ProductType> productTypes;
    private ArrayList<Zone> zones;
    private ArrayList<Customer> customers;

    private DB(){}

    public static DB getInstance() {
        if (db == null){
            db = new DB();
        }
        return db;
    }


    public ArrayList<Supplier> getSuppliers() {
        if (suppliers == null) {
            suppliers = new ArrayList<>();
        }
        return suppliers;
    }

    public ArrayList<ProductType> getProductTypes() {
        if (productTypes == null) {
            productTypes = new ArrayList<>();
        }
        return productTypes;
    }

    public ArrayList<Zone> getZones() {
        if (zones == null) {
            zones = new ArrayList<>();
        }
        return zones;
    }

    public ArrayList<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public ArrayList<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        return customers;
    }
}
