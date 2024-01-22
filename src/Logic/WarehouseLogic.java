package Logic;

import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.StockPosition;
import classes.warehouse.Warehouse;
import Logic.*;

import java.util.ArrayList;

public class WarehouseLogic {
    // CREA SETTORE MAGAZZINO
    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth) {

        Warehouse newZone = new Warehouse(zoneName, zoneLongness, zoneHeigth);
        int zoneLength = newZone.getZoneCapacity();
        ArrayList<StockPosition> myPositions = newZone.getPositions();
        for (int index = 0; index < zoneLength; index++) {
            StockPosition newPosition = new StockPosition(zoneLongness);
            myPositions.add(newPosition);
            myPositions.get(index).setIsContainedIn(newZone.getZoneName());
        }
        StockPoisitionLogic.resetPosition();
        Warehouse.getWarehouseZones().add(newZone);
    }
    // CONTROLLA TUTTE POSIZIONI VUOTE O PIENE
    public static void checkFullPositions(int selectedZone){
        selectedZone--;
        ArrayList<StockPosition> myPositions = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        for (StockPosition element : myPositions){
            if (element.isPositionEmpty()){
                System.out.println(element);
            }
        }
    }
    public static void checkEmptyPositions(int selectedZone){
        selectedZone--;
        ArrayList<StockPosition> myPositions = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        for (StockPosition element : myPositions){
            if (!element.isPositionEmpty()){
                System.out.println(element);
            }
        }
    }

    // IL METODO DOVRA' INSERIRE TOT PRODOTTI SCELTI DALL UTENTE NELLA ZONA SCELTA
    public static void stockingManagement(int input, int WarehouseZone,int Quantity, String productName, String productBrand, String productDescription, double productPrice) {
        WarehouseZone--;

        try {

            Warehouse selectedZone = Warehouse.getWarehouseZones().get(WarehouseZone);
            int stockedProducts = selectedZone.getStockProductCounter();
            System.out.println("quantità prodotti " + input + " nel settore " + selectedZone.getZoneName() +
                    " di capacità: " + (selectedZone.getZoneCapacity() - stockedProducts));
            for (int cycles = 0; cycles < input; cycles++){

                System.out.println("utente seleziona il numero " + cycles + " prodotto da inserire");
            if ((selectedZone.getZoneCapacity() - stockedProducts) >= input) {

                productStockIn(WarehouseZone, Quantity, productName, productBrand, productDescription, productPrice);

            } else {
                throw new RuntimeException("Capacità settore non sufficiente " + (selectedZone.getZoneCapacity() - stockedProducts));
            }
        }
        }catch (RuntimeException e) {
            System.out.println(e);
        }

    }


    public static void productStockIn(int WarehouseZoneSingle, int Quantity, String productName, String productBrand, String productDescription, double productPrice) {

        Warehouse selectedZone = Warehouse.getWarehouseZones().get(WarehouseZoneSingle);
        int stockCounter = selectedZone.getStockProductCounter();
        ProductType productNewId = new ProductType(productName, productBrand);
        Product newProduct = new Product(productName, productBrand, productDescription, productPrice, productNewId, selectedZone.getPositions().get(stockCounter));
        selectedZone.getPositions().get(stockCounter).setProductRefId(newProduct.getID());
        selectedZone.getPositions().get(stockCounter).setStockedProduct(newProduct);
        selectedZone.getPositions().get(stockCounter).setQuantity(Quantity);
        selectedZone.incrementStockProductCounter();
    }

    // RICERCA PRODOTTI
    // by name and brand
    public static void searchByName(String name, String brand, int selectedZone) {
        selectedZone--;
        ArrayList<StockPosition> sector = Warehouse.getWarehouseZones().get(selectedZone).getPositions();

        for (StockPosition position : sector) {
            try {
                String checkName = position.getStockedProduct().getName();
                String checkBrand = position.getStockedProduct().getBrand();

                if (checkName != null && checkBrand != null) {
                    if (checkName.equalsIgnoreCase(name) && checkBrand.equalsIgnoreCase(brand)){
                        System.out.println(position.getStockedProduct());
                        System.out.println(position.getStockedProduct().getPosition().getQuantity());
                    }
                }
            } catch (RuntimeException e) {}
        }
    }
    public static void searchByID(String str, int selectedZone){
        selectedZone--;
        ArrayList<StockPosition> sector = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        for (StockPosition position : sector) {
            try {
                String checkID = position.getStockedProduct().getID();
                if (checkID != null) {
                    if (checkID.equalsIgnoreCase(str)) {
                        System.out.println(position.getStockedProduct().getPosition());
                        System.out.println(position.getStockedProduct().getPosition().getQuantity());
                    }
                }
            } catch (RuntimeException e) {}
        }

    }
    public static void searchByLot(String str, int selectedZone) {
        selectedZone--;
        StringBuilder lot = new StringBuilder(str);
        ArrayList<StockPosition> sector = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        int indexOfMiddle = lot.indexOf("L");
        String firstParameter = lot.substring(0, indexOfMiddle);
        String secondParameter = lot.substring(indexOfMiddle, lot.length() - 1);
        for (StockPosition position : sector) {

            StringBuilder checkLot = position.getLot();
            String firstComparison = checkLot.substring(0, indexOfMiddle);
            String secondComparison = checkLot.substring(indexOfMiddle, checkLot.length() - 1);
            if (firstParameter.equalsIgnoreCase(firstComparison) && secondParameter.equalsIgnoreCase(secondComparison)) {
                System.out.println(position.getStockedProduct());
                System.out.println(position.getStockedProduct().getPosition().getQuantity());
            }
        }

    }
}
