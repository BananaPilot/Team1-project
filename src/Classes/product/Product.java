package Classes.product;

import java.time.LocalDateTime;
import java.util.UUID;

import Classes.productType.ProductType;
import Classes.Supplier.*;
import Classes.Warehouse.StockPosition;

public class Product {
	
	private String ID; 
	private String name;
	private String brand;
	private String description;
	private double price;
	private final LocalDateTime stockDate;
	private Supplier supplierID;
	private ProductType productTypeID;
	private StockPosition position;
	
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

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", brand=" + brand + ", description=" + description + ", price="
				+ price + ", stockDate=" + stockDate + ", supplierID=" + supplierID + ", productTypeID=" + productTypeID
				+ ", position=" + position + "]";
	}
	
}
