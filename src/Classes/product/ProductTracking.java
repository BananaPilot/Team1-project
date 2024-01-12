package Classes.product;

import Classes.Supplier.Supplier;
import Classes.Warehouse.StockPosition;
import Classes.productType.ProductType;

public class ProductTracking extends Product {
	
	public ProductTracking(String name, String brand, String description, double price,
			Supplier supplierID, ProductType productTypeID, StockPosition position,
			int in, int currentQuantity, int out, int disposedOf) {
		super(name, brand, description, price, supplierID, productTypeID, position);
		this.in = in;
		this.currentQuantity = currentQuantity;
		this.out = out;
		this.disposedOf = disposedOf;
	}
	
	private int in;
	private int currentQuantity;
	private int out;
	private int disposedOf;
	
	public int getIn() {
		return in;
	}
	public void setIn(int in) {
		this.in = in;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
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
	@Override
	public String toString() {
		return "ProductTracking [in=" + in + ", currentQuantity=" + currentQuantity + ", out=" + out + ", disposedOf="
				+ disposedOf + "]";
	}
	
}
