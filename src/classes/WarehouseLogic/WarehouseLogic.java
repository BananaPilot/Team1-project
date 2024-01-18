package classes.WarehouseLogic;

import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.StockPosition;
import classes.warehouse.Warehouse;
import classes.WarehouseLogic.*;

import java.util.ArrayList;

public class WarehouseLogic {

    private static int selectedZoneMemory = 0;

    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth){

        Warehouse newZone = new Warehouse(zoneName,zoneLongness,zoneHeigth);
        int zoneLength = newZone.getZoneCapacity();
        ArrayList<StockPosition> myPositions = newZone.getPositions();
        for (int index = 0; index < zoneLength; index++){
            StockPosition newPosition = new StockPosition(zoneLongness);
            myPositions.add(newPosition);
            myPositions.get(index).setIsContainedIn(newZone.getZoneName());
        }
        StockPoisitionLogic.resetPosition();
        Warehouse.getWarehouseZones().add(newZone);
    }

    // IL METODO DOVRA' INSERIRE TOT PRODOTTI SCELTI DALL UTENTE NELLA ZONA SCELTA
    public static void stockingManagement(int input,int WarehouseZone,String productName, String productBrand,String productDescription, double productPrice){
        WarehouseZone--;

        try {


            Warehouse selectedZone = Warehouse.getWarehouseZones().get(WarehouseZone);
            int stockedProducts = selectedZone.getStockProductCounter();
            System.out.println("quantità prodotti " + input + " nel settore " + selectedZone.getZoneName() +
                    " di capacità: " + (selectedZone.getZoneCapacity()-stockedProducts));

            if ((selectedZone.getZoneCapacity()-stockedProducts) >= input) {
                for (int i = 0; i < input; i++) {
                    productStockIn(WarehouseZone, productName, productBrand, productDescription, productPrice);
                }
            } else {
                throw new RuntimeException("Capacità settore non sufficiente " + (selectedZone.getZoneCapacity()-stockedProducts));
            }
        } catch (RuntimeException e){
            System.out.println(e);
        }
        Warehouse.getAllPositions(WarehouseZone);
    }



    public static void productStockIn(int WarehouseZone,String productName, String productBrand,String productDescription, double productPrice){
        Warehouse selectedZone = Warehouse.getWarehouseZones().get(WarehouseZone);
        int stockCounter = selectedZone.getStockProductCounter();



        ProductType productNewId = new ProductType(productName,productBrand);
        Product newProduct = new Product(productName,productBrand,productDescription,productPrice,productNewId,selectedZone.getPositions().get(stockCounter));
        selectedZone.getPositions().get(stockCounter).setProductRefId(newProduct.getID());
        selectedZone.getPositions().get(stockCounter).setStockedProduct(newProduct);

        selectedZone.incrementStockProductCounter();
        }
    }


