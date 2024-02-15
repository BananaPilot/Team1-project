package classes.supplier;

import classes.shared.Contacts;
import classes.interfaces.Searchable;
import classes.shared.Order;
import classes.shared.Placeholder;

import java.util.ArrayList;
import java.util.UUID;

public class Supplier extends Placeholder implements Searchable {
    private String companyName;
    private int suppliedProductType;
    private String VATNumber;

    public Supplier(String companyName, String address, int suppliedProductType, String VATNumber, String email, String phoneNumber) {
        super(address, email, phoneNumber);
        this.companyName = companyName;
        this.suppliedProductType = suppliedProductType;
        this.VATNumber = VATNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getSuppliedProductType() {
        return suppliedProductType;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSuppliedProductType(int suppliedProductType) {
        this.suppliedProductType = suppliedProductType;
    }
    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "companyName='" + companyName + '\'' +
                ", suppliedProductType=" + suppliedProductType +
                ", VATNumber='" + VATNumber + '\'' +
                "} " + super.toString();
    }
}
