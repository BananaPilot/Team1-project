package classes.warehouse;
import classes.product.Product;


public class Position {
    private int positionId = 0;//a che serve questo?
    private static int staticpositionId = 0;//?? cosé sta robba?
    private int level = 0;// creare il lot attravero metodo
    private static int staticLevel = 0;// immmettere nel metodo di creazione
    private boolean isFull = false;
    private String productRefId;//inutile
    private StringBuilder lot = new StringBuilder("");//convertire to string
    private Product product;//ok
    private static int staticLongnessCounter = 0;//immettere un metodo che li passa come parametri
    private String isContainedIn; //?
    private int quantity;//ok

    public Position(int zoneLongness, String zoneReference){

        if (staticLongnessCounter == zoneLongness ){
            staticLongnessCounter = 0;
            staticLevel++;
        }
        this.isContainedIn = zoneReference;
        this.staticpositionId++;
        this.positionId = staticpositionId;
        this.level = staticLevel;
        this.lot.append(this.positionId + "L" + this.level);
        staticLongnessCounter++;
    }
    public Position(){}
    public Product getProduct() {
        return product;
    }
    public String getIsContainedIn() {
        return isContainedIn;
    }
    public void setIsContainedIn(String isContainedIn) {
        this.isContainedIn = isContainedIn;
    }
    public static void resetPosition(){
        staticLevel = 0;
        staticLongnessCounter = 0;
    }
    public boolean isPositionEmpty(){
        return this.isFull;
    }
    public void setFull(boolean full) {
        isFull = full;
    }
    public void setExistentPosition(Position position){
        this.setProduct(position.getProduct());
        this.setQuantity(position.getQuantity());
        this.setFull(position.isPositionEmpty());
        this.setProductRefId(position.getProductRefId());
        this.setIsContainedIn(position.getIsContainedIn());
        this.product.setPosition(this);
    }
    public void removeProduct(){
        this.product.setPosition(null);
        this.product = null;
        this.quantity = 0;
        this.productRefId = null;
        this.isFull = false;
    }
    public StringBuilder getLot() {
        return lot;
    }
    public void setProductRefId(String productRefId) {
        this.productRefId = productRefId;
    }
    public String getProductRefId() {
        return productRefId;
    }
    public void setProduct(Product product) {
        this.product = product;
        this.isFull = true;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public static void setStaticLevel(int staticLevel) {
        Position.staticLevel = staticLevel;
    }
    public static void setStaticLongnessCounter(int staticLongnessCounter) {
        Position.staticLongnessCounter = staticLongnessCounter;
    }

    @Override
    public String toString() {
        return
                "ID:" + positionId +
                        " LOT: " + lot +
                        " IS-FULL: " + isFull +
                        " PROD-ID: " + productRefId +
                        " QUANT: " + quantity +
                        " ZONE: " + isContainedIn +
                        " PROD: " + product;
    }
}
