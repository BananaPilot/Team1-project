package classes.supplier;

import classes.shared.Searchable;
import classes.shared.OrderPlacer;

public class Supplier extends OrderPlacer {
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
