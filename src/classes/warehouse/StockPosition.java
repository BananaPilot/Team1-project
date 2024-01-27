package classes.warehouse;
import classes.product.Product;


public class StockPosition {
    private int positionId = 0;
    private String isContainedIn;
    private static int staticpositionId = 0;
    private int heigth = 0;
    private int quantity;
    private static int staticHeigth = 0;
    private boolean isFull = false;
    private String productRefId;
    private StringBuilder lot = new StringBuilder();
    private Product stockedProduct;
    private static int staticLongnessCounter = 0;

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


    public int getPositionId(){
        return this.positionId;
    }

    public Product getStockedProduct() {
        return stockedProduct;
    }

    public void setIsContainedIn(String isContainedIn) {
        this.isContainedIn = isContainedIn;
    }

    public void setIsPositionEmpty(boolean isFull){
        this.isFull  = isFull;
    }
    public boolean isPositionEmpty(){
        return this.isFull;
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
                "ID: " + positionId +
                " LOT: " + lot +
                " IS-FULL: " + isFull +
                " PROD-ID: " + productRefId +
                " QUANT: " + quantity +
                " ZONE: " + isContainedIn +
                " PROD: " + stockedProduct;

    }
}
