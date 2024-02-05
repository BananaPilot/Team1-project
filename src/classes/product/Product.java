package classes.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import classes.interfaces.Searchable;
import classes.productType.ProductType;
import classes.supplier.*;
import classes.warehouse.Position;

public class Product implements Searchable {

    private final String ID;
    private String name;
    private String brand;
    private String description;
    private double price;
    private int currentQuantity; //set e get calcolati
    private final LocalDateTime stockDate;
    private final Supplier supplier;
    private final ProductType productType;
    private Position position;
    private final ArrayList<ProductTracking> productTrackings = new ArrayList<>();

    public ArrayList<ProductTracking> getProductTrackings() {
        return productTrackings;
    }

    public Product(String name, String brand, String description, double price,
                   Supplier supplier, ProductType productType, Position position) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.currentQuantity = 0;
        this.stockDate = LocalDateTime.now();
        this.supplier = supplier;
        this.productType = productType;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStockDate() {
        return stockDate;
    }

    public String getID() {
        return ID;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public String toString() {
        return "Product [ID=" + ID + ", name=" + name + ", brand=" + brand + ", description=" + description
                + ", price=" + price + ", stockDate=" + stockDate + ", supplierID=" + supplier
                + ", productTypeID=" + productType + ", position=" + position + "]";
    }

}

class ProductTracking {

    private int in;
    private int out;
    private int disposedOf;
    private final LocalDateTime stockDate;

    public ProductTracking() {
        this.stockDate = LocalDateTime.now();
        this.in = 0;
        this.out = 0;
        this.disposedOf = 0;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getDisposedOf() {
        return disposedOf;
    }

    public void setDisposedOf(int disposedOf) {
        this.disposedOf = disposedOf;
    }

    public LocalDateTime getStockDate() {
        return stockDate;
    }

    public int getCurrentQuantity() {
        return in - out - disposedOf;
    }

    @Override
    public String toString() {
        return "ProductTracking [in=" + in + ", currentQuantity=" + getCurrentQuantity() + ", out=" + out
                + ", disposedOf=" + disposedOf + "]";
    }
}