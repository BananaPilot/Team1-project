package database;

import java.util.ArrayList;
import java.util.Arrays;

import classes.warehouse.Position;
import classes.product.Product;
import classes.productType.ProductType;
import classes.supplier.Supplier;
import classes.warehouse.Zone;

public class DB {
    private static ArrayList<Zone> zones = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<Product>();
    public static ArrayList<Supplier> suppliers = new ArrayList<Supplier>(Arrays.asList(
            new Supplier(null, null, 0, null, null, null),
            new Supplier(null, null, 0, null, null, null)
    ));
    public static ArrayList<ProductType> productTypes = new ArrayList<ProductType>(Arrays.asList(
            new ProductType(null, null)
    ));
    public static ArrayList<Position> positions = new ArrayList<Position>(Arrays.asList(
            new Position()
    ));
    
    
    
    public static ArrayList<Zone> getWarehouseZones() {
        return zones;
    }
}
