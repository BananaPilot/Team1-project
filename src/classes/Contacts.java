package classes;

public class Contacts {
  private String email;
  private String phoneNumber;

  public Contacts(String email, String phoneNumber) {
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Contacts{" +
            "email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
  }
}
