package Classes;

public class Orders {
    private int counter = 1;
    final int ID;


//QUI CI VANNO GLI "ORDERED PRODUCTS"/"PRODUCTS" MA NON SO COME ADDARLI, E' 1 ORA CHE BATTO LA TESTA SULLA
//TASTIERA MA NON ESCE NULLA... non so se ci va qualcosa tra i constructor, devo ripassare un po' di roba


    private long date;
    private double totalOrder;

    public Orders(int ID, long date, double totalOrder) {
        this.ID = incrementAndGet();
        this.date = date;
        this.totalOrder = totalOrder;

    }

    final int getID() {
        return ID;
    }
    public long getDate() {
        return date;
    }
    public double getTotalOrder() {
        return totalOrder;
    }

    public void setDate(long date) {
        this.date = date;
    }
    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }
    private int incrementAndGet() {
        return counter ++;
    }

    @Override
    public String toString() {
        return "Order ID: " + ID + "\nDate: " + date + "Products: " + "Total: " + totalOrder;
    }
}
