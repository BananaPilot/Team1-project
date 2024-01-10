package Classes.Supplier;

public class OrderedProduct {
    private int orderedQuantity;
    private String name;
    private String brand;
    private final double price;

    public OrderedProduct(int orderedQuantity, String name, String brand, double price) {
        this.orderedQuantity = orderedQuantity;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "OrderedProducts{" +
                "orderedQuantity=" + orderedQuantity +
                ", name='" + name + '\'' +
                ", Brand='" + brand + '\'' +
                '}';
    }
}
