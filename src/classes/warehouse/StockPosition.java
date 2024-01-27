package classes.warehouse;
import classes.product.Product;


public class StockPosition {
    private int positionId = 0;
    private static int staticpositionId = 0;
    private int heigth = 0;
    private static int staticHeigth = 0;
    private boolean isFull = false;
    private String productRefId;
    private StringBuilder lot = new StringBuilder("");
    private Product stockedProduct;
    private static int staticLongnessCounter = 0;
    private String isContainedIn;
    private int quantity;

    public StockPosition(int zoneLongness, String zoneReference){

        if (staticLongnessCounter == zoneLongness ){
            staticLongnessCounter = 0;
            staticHeigth++;
        }
        this.isContainedIn = zoneReference;
        this.staticpositionId++;
        this.positionId = staticpositionId;
        this.heigth = staticHeigth;
        this.lot.append(this.positionId + "L" + this.heigth);
        staticLongnessCounter++;
    }
    public StockPosition(){}




    public Product getStockedProduct() {
        return stockedProduct;
    }

    public String getIsContainedIn() {
        return isContainedIn;
    }

    public void setIsContainedIn(String isContainedIn) {
        this.isContainedIn = isContainedIn;
    }

    public static void resetPosition(){
        staticHeigth = 0;
        staticLongnessCounter = 0;
    }
    //getter e setters

    public int getPositionId(){
        return this.positionId;
    }
    //public int productRefId(){return ID;}
    public boolean isPositionEmpty(){
        return this.isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
    public void setExistentPosition(StockPosition position){


        this.setStockedProduct(position.getStockedProduct());
        this.setQuantity(position.getQuantity());
        this.setFull(position.isPositionEmpty());
        this.setProductRefId(position.getProductRefId());
        this.setIsContainedIn(position.getIsContainedIn());
        this.stockedProduct.setPosition(this);
    }
    public void removeProduct(){
        this.stockedProduct.setPosition(null);
        this.stockedProduct = null;
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

    public void setStockedProduct(Product stockedProduct) {
        this.stockedProduct = stockedProduct;
        this.isFull = true;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void setStaticHeigth(int staticHeigth) {
        StockPosition.staticHeigth = staticHeigth;
    }

    public static void setStaticLongnessCounter(int staticLongnessCounter) {
        StockPosition.staticLongnessCounter = staticLongnessCounter;
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
                        " PROD: " + stockedProduct;
    }
}
