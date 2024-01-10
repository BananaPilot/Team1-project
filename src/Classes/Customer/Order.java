package Classes.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private final ArrayList<String> IDProducts;
    private final LocalDateTime PurchaseDate;
    private double Total;

    public Order(ArrayList<String> IDProducts){
        this.IDProducts = IDProducts;
        this.PurchaseDate = LocalDateTime.now();
        //TODO implement Total
    }

    public ArrayList<String> getIDProducts() {
        return IDProducts;
    }

    public LocalDateTime getPurchaseDate() {
        return PurchaseDate;
    }

    public double getTotal() {
        return Total;
    }



}
