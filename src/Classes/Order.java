package Classes;

public interface Order {
  default double getTotal() {
    return 0.0;
  }
}
