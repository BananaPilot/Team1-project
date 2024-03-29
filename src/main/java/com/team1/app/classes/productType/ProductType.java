package com.team1.app.classes.productType;

import com.team1.app.classes.shared.Searchable;

import java.util.ArrayList;
import java.util.UUID;

public class ProductType extends Searchable {

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

    public static ProductType search(ArrayList<ProductType> productTypes, Object value) {
        for (ProductType productType : productTypes) {
            if (productType.contains(value)) return productType;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Product Type [ID = " + ID +
                ", Name = " + name +
                ", Description = " + description + "]";
    }
}
