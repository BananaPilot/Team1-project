package classes.WarehouseLogic;

import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.StockPosition;
import classes.warehouse.Warehouse;
import classes.WarehouseLogic.*;

import java.util.ArrayList;

public class WarehouseLogic {

    private static int stockProductCounter = 0;
    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth){

        Warehouse newZone = new Warehouse(zoneName,zoneLongness,zoneHeigth);
        int zoneLength = newZone.getZoneCapacity();
        ArrayList<StockPosition> myPositions = newZone.getPositions();
        for (int index = 0; index < zoneLength; index++){
            StockPosition newPosition = new StockPosition(zoneLongness);
            myPositions.add(newPosition);
        }
        StockPoisitionLogic.resetPosition();
        Warehouse.getWarehouseZones().add(newZone);
    }

    public static void productStockIn(int WarehouseZone,String productName, String productBrand,String productDescription, double productPrice){
        ProductType productNewId = new ProductType(productName,productBrand);
        Warehouse selectedZone = Warehouse.getWarehouseZones().get(WarehouseZone);

        Product newProduct = new Product(productName,productBrand,productDescription,productPrice,productNewId,selectedZone.getPositions().get(stockProductCounter));
        selectedZone.getPositions().get(stockProductCounter).setProductRefId(newProduct.getID());
        selectedZone.getPositions().get(stockProductCounter).setStockedProduct(newProduct);


        stockProductCounter++;
    }

}
