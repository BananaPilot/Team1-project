package Logic;

import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.StockPosition;
import classes.warehouse.Warehouse;
import Logic.*;

import java.util.ArrayList;
import java.util.Arrays;

public class WarehouseLogic {
    // CREA SETTORE MAGAZZINO
    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth) {

        Warehouse newZone = new Warehouse(zoneName, zoneLongness, zoneHeigth);
        ArrayList<StockPosition> myPositions = newZone.getPositions();

        for (int index = 0; index < newZone.getZoneCapacity(); index++) {
            StockPosition newPosition = new StockPosition(zoneLongness, zoneName);
            myPositions.add(newPosition);
        }
        StockPoisitionLogic.resetPosition();
        Warehouse.getWarehouseZones().add(newZone);
    }
    // CONTROLLA TUTTI I SETTORI

    public static void checkWarehouses(){
        for (Warehouse settore : Warehouse.getWarehouseZones()){
            System.out.println(settore);
        }
    }
    // CONTROLLA TUTTE POSIZIONI VUOTE O PIENE
    public static void checkFullPositions(int selectedZone){
        selectedZone--;
        ArrayList<StockPosition> myPositions = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        for (StockPosition element : myPositions){

                System.out.println(element);

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
    public static Product searchByLot(String lot, int selectedZone) {
        selectedZone--;

        ArrayList<StockPosition> sector = Warehouse.getWarehouseZones().get(selectedZone).getPositions();
        Product risultato = null;
        for (StockPosition position : sector) {

            String firstComparison = convertLotFirst(position.getLot().toString());
            String secondComparison = convertLotSecond(position.getLot().toString());

            if ( convertLotFirst(lot).equalsIgnoreCase(firstComparison) && convertLotSecond(lot).equalsIgnoreCase(secondComparison)) {
                System.out.println(position.getStockedProduct());
                System.out.println(position.getStockedProduct().getPosition().getQuantity());
                risultato = position.getStockedProduct();
            }
        }
        return risultato;
    }
    // MODIFICARE POSIZIONE
    // FUNZIONA MA NON RIESCO CON LE POSIZIONI VUOTE

    public static void restockProduct(int zone, String lot, String lot2) {
        zone--;
        ArrayList<StockPosition> sector = Warehouse.getWarehouseZones().get(zone).getPositions();
        StockPosition selectedPosition1 = null;
        StockPosition selectedPosition2 = null;

        for (StockPosition position : sector) {

            String firstComparison = convertLotFirst(position.getLot().toString());
            String firstComparison2 = convertLotSecond(position.getLot().toString());

            if (convertLotFirst(lot.toString()).equalsIgnoreCase(firstComparison)
            &&  convertLotSecond(lot.toString()).equalsIgnoreCase(firstComparison2)) {
                selectedPosition1 = position;
                selectedPosition1.setStockedProduct(position.getStockedProduct());
            }
            if (convertLotFirst(lot2.toString()).equalsIgnoreCase(firstComparison)
            && convertLotSecond(lot2.toString()).equalsIgnoreCase(firstComparison2)){
                selectedPosition2 = position;
                selectedPosition2.setStockedProduct(position.getStockedProduct());
            }
        }

        StockPosition temporary = new StockPosition();
        if (selectedPosition1.getStockedProduct() == null){
            selectedPosition1.setExistentPosition(selectedPosition2);
            selectedPosition2.removeProduct();
            return;
        } else if (selectedPosition2.getStockedProduct() == null){
            selectedPosition2.setExistentPosition(selectedPosition1);
            selectedPosition1.removeProduct();
        } else {
            temporary.setExistentPosition(selectedPosition1);
            selectedPosition1.setExistentPosition(selectedPosition2);
            selectedPosition2.setExistentPosition(temporary);
        }

    }

    // CANCELLA SETTORE

    public static void deleteSector(int zone){
        zone--;
        Warehouse.getWarehouseZones().remove(zone);
    }

    public static String convertLotFirst(String str){
        StringBuilder lot = new StringBuilder(str);
        int indexOfMiddle = lot.indexOf("L");
        return lot.substring(0, indexOfMiddle);
    }
    public static String convertLotSecond(String str){
        StringBuilder lot = new StringBuilder(str);
        int indexOfMiddle = lot.indexOf("L");
        return lot.substring(indexOfMiddle, lot.length() - 1);
    }


    // TEMPORANEO
    public static void promptCreaProdotto(){

    }
}
