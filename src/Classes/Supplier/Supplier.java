package Classes.Supplier;

public class Supplier {
  private int counter = 1;
  private int ID;
  private String companyName;
  private String address;
  private int suppliedProductType;
  private String VATNumber;

  //TODO operations;
  //TODO contacts;

  public Supplier(String companyName, String address, int suppliedProductType, String VATNumber) {
    this.ID = incrementAndGet();
    this.companyName = companyName;
    this.address = address;
    this.suppliedProductType = suppliedProductType;
    this.VATNumber = VATNumber;
  }

  public int getID() {
    return ID;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAddress() {
    return address;
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

  public void setAddress(String address) {
    this.address = address;
  }

  public void setSuppliedProductType(int suppliedProductType) {
    this.suppliedProductType = suppliedProductType;
  }

  public void setVATNumber(String VATNumber) {
    this.VATNumber = VATNumber;
  }

  private int incrementAndGet() {
    return counter ++;
  }
}
