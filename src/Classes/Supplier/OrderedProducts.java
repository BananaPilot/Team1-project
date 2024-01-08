package Classes.Supplier;

public class OrderedProducts {
    private int orderedQuantity;
    private String name;
    private String Brand;

    public OrderedProducts(int orderedQuantity, String name, String brand) {
        this.orderedQuantity = orderedQuantity;
        this.name = name;
        Brand = brand;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return Brand;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBrand(String brand) {
        Brand = brand;
    }

    @Override
    public String toString() {
        return "Product QT: " + orderedQuantity + "Product name: " + name + "Product Brand: " + Brand;
    }
}
