package classes;

import classes.product.Product;

public class OrderProduct {
    private int orderQty;
    private Product product;

    public OrderProduct(int orderQty, Product product) {
        this.orderQty = orderQty;
        this.product = product;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderQty=" + orderQty +
                ", product=" + product +
                '}';
    }
}
