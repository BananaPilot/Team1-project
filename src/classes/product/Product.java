package classes.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import classes.productType.ProductType;
import classes.supplier.*;
import classes.warehouse.StockPosition;

public class Product {

	private final String ID;
	private String name;
	private String brand;
	private String description;
	private Integer currentQuantity;
	private double price;
	private final LocalDateTime stockDate;
	private Supplier supplierID;
	private ProductType productTypeID;
	private StockPosition position;
	private ArrayList<ProductTracking> productTrackings;

	public Product(String name, String brand, String description, double price,
			Supplier supplierID, ProductType productTypeID, StockPosition position) {
		this.ID = UUID.randomUUID().toString();
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.price = 0;
		this.stockDate = LocalDateTime.now();
		this.supplierID = supplierID;
		this.productTypeID = productTypeID;
		this.position = position;
		this.productTrackings = new ArrayList<ProductTracking>();
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
	
	public Integer getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity() {
		this.currentQuantity = 
				getCurrentQuantity()
				+ productTrackings.get(productTrackings.size()-1).getIn()
				- productTrackings.get(productTrackings.size()-1).getOut()
				- productTrackings.get(productTrackings.size()-1).getDisposedOf();
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

	public ArrayList<ProductTracking> getProductTrackings() {
		return productTrackings;
	}

	public void setProductTrackings(ArrayList<ProductTracking> productTrackings) {
		this.productTrackings = productTrackings;
	}
	
	public void addProductTracking(int in, int out, int disposedOf) {
		this.productTrackings.add(new ProductTracking(in, out, disposedOf));
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", brand=" + brand + ", description=" + description 
				+ ", price=" + price + ", stockDate=" + stockDate + ", supplierID=" + supplierID 
				+ ", productTypeID=" + productTypeID + ", position=" + position + "]";
	}
	
	public class ProductTracking{
		
		private Integer in;
		private Integer out;
		private Integer disposedOf;
		private final LocalDateTime stockDate;
		
		public ProductTracking(int in, int out, int disposedOf) {
			this.stockDate  = LocalDateTime.now();
			this.in = in;
			this.out = out;
			this.disposedOf = disposedOf;
		}
		
		public ProductTracking() {
			this.stockDate  = LocalDateTime.now();
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
		@Override
		public String toString() {
			return "ProductTracking [in=" + in + ", currentQuantity=" + currentQuantity + ", out=" + out 
					+ ", disposedOf=" + disposedOf + "]";
		}
	}
}