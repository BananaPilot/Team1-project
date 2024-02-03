package classes.productType;

import classes.interfaces.Searchable;

import java.util.ArrayList;
import java.util.UUID;

public class ProductType implements Searchable {

    private final String ID;

    private String name;

    private String description;

    public ProductType(String name, String description) {
        this.name = name;
        this.description = description;
        this.ID = UUID.randomUUID().toString();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ProductType search(ArrayList<ProductType> productTypes, Object value){
        for (ProductType productType: productTypes){
            if (productType.contains(value)) return productType;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
