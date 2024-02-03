package classes.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import classes.interfaces.Searchable;
import classes.productType.ProductType;
import classes.supplier.*;
import classes.warehouse.StockPosition;

public class Product implements Searchable {

  private final String ID;
  private String name;
  private String brand;
  private String description;
  private double price;
  private final LocalDateTime stockDate;
  private Supplier supplierID;
  private ProductType productTypeID;
  private StockPosition position;
  private ProductTracking productTracking;

  public Product(String name, String brand, String description, double price,
                 Supplier supplierID, ProductType productTypeID, StockPosition position) {
    this.ID = UUID.randomUUID().toString();
    this.name = name;
    this.brand = brand;
    this.description = description;
    this.price = price;
    this.stockDate = LocalDateTime.now();
    this.supplierID = supplierID;
    this.productTypeID = productTypeID;
    this.position = position;
    this.productTracking = new ProductTracking();
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

  public Supplier getSupplierID() {
    return supplierID;
  }

  public ProductType getProductTypeID() {
    return productTypeID;
  }

  public StockPosition getPosition() {
    return position;
  }

  public void setPosition(StockPosition position) {
    this.position = position;
  }

  public ProductTracking getProductTracking() {
    return productTracking;
  }

  public void setProductTracking(ProductTracking productTracking) {
    this.productTracking = productTracking;
  }

  @Override
  public String toString() {
    return "Product [ID=" + ID + ", name=" + name + ", brand=" + brand + ", description=" + description
            + ", price=" + price + ", stockDate=" + stockDate + ", supplierID=" + supplierID
            + ", productTypeID=" + productTypeID + ", position=" + position + "]";
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