package classes.database;

import classes.customer.Customer;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.zone.Zone;

import java.util.ArrayList;
import java.util.List;

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


    public List<Supplier> getSuppliers() {
        if (suppliers == null) {
            suppliers = new ArrayList<>();
        }
        return suppliers;
    }

    public List<ProductType> getProductTypes() {
        if (productTypes == null) {
            productTypes = new ArrayList<>();
        }
        return productTypes;
    }

    public List<Zone> getZones() {
        if (zones == null) {
            zones = new ArrayList<>();
        }
        return zones;
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        return customers;
    }
}
