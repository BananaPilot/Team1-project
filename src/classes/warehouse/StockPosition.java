package classes.warehouse;
import classes.product.Product;


public class StockPosition {
    private int positionId = 0;
    private String isContainedIn;

    private static int staticpositionId = 0;
    private int heigth = 0;
    private static int staticHeigth = 0;
    private boolean isFull = false;
    private String productRefId;
    private StringBuilder lot = new StringBuilder(" ");
    private Product stockedProduct;
    private static int staticLongnessCounter = 0;

    public StockPosition(int zoneLongness){

        if (staticLongnessCounter == zoneLongness ){
            staticLongnessCounter = 0;
            staticHeigth++;
        }

        this.staticpositionId++;
        this.positionId = staticpositionId;
        this.heigth = staticHeigth;
        this.lot.append(positionId + "L" + this.heigth);
        staticLongnessCounter++;
    }


    public int getPositionId(){
        return this.positionId;
    }

    public void setIsContainedIn(String isContainedIn) {
        this.isContainedIn = isContainedIn;
    }


    public boolean isPositionEmpty(){
        return this.isFull;
    }


    public StringBuilder getLot() {
        return lot;
    }

    public void setProductRefId(String productRefId) {
        this.productRefId = productRefId;
    }

    public void setStockedProduct(Product stockedProduct) {
        this.stockedProduct = stockedProduct;
        this.isFull = true;
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
                "positionId= " + positionId +
                " lot=" + lot +
                ", isFull=" + isFull +
                ", productRefId= " + productRefId +
                ", Stock Product= " + stockedProduct +
                        ", assigned zone " + isContainedIn;
    }
}
