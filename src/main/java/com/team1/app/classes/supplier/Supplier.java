package com.team1.app.classes.supplier;

import com.team1.app.classes.productType.ProductType;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.shared.OrderPlacer;

public class Supplier extends OrderPlacer {
    private String companyName;
    private ProductType suppliedProductType;
    private String VATNumber;

    public Supplier(String companyName, String address, ProductType suppliedProductType, String VATNumber, String email, String phoneNumber) {
        super(address, email, phoneNumber);
        this.companyName = companyName;
        this.suppliedProductType = suppliedProductType;
        this.VATNumber = VATNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ProductType getSuppliedProductType() {
        return suppliedProductType;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSuppliedProductType(ProductType suppliedProductType) {
        this.suppliedProductType = suppliedProductType;
    }
    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" + '\n' +
                super.toString() +
                "companyName: " + companyName + '\n' +
                "suppliedProductType: " + suppliedProductType + '\n' +
                "VATNumber: " + VATNumber + '\n' +
                "} ";
    }
}
