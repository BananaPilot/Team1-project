package interactions.warehouse.Logic;

import classes.product.Product;
import classes.productType.ProductType;
import classes.warehouse.Position;
import classes.warehouse.Zone;

import java.util.ArrayList;

public class WarehouseLogic {
    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth) {

        Zone newZone = new Zone(zoneName, zoneLongness, zoneHeigth);
        ArrayList<Position> myPositions = newZone.getPositions();
        for (int index = 0; index < newZone.getZoneCapacity(); index++) {
            Position newPosition = new Position(zoneLongness, zoneName);
            myPositions.add(newPosition);
        }
        PositionLogic.resetPosition();
        Zone.getWarehouseZones().add(newZone);
    }

    // CONTROLLA TUTTI I SETTORI
    public static void checkWarehouses(){
        for (Zone settore : Zone.getWarehouseZones()){
            System.out.println(settore);
        }
    }
    // CONTROLLA TUTTE POSIZIONI VUOTE O PIENE
    public static void checkPositions(int selectedZone){
        selectedZone--;
        ArrayList<Position> myPositions = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position element : myPositions){
                System.out.println(element);
        }
    }
    public static void checkEmptyPositions(int selectedZone){
        selectedZone--;
        ArrayList<Position> myPositions = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position element : myPositions){
            if (!element.isPositionEmpty()){
                System.out.println(element);
            }
        }
    }

    // IL METODO DOVRA' INSERIRE TOT PRODOTTI SCELTI DALL UTENTE NELLA ZONA SCELTA
    public static void stockingManagement(int input, int WarehouseZone,int Quantity, String productName, String productBrand, String productDescription, double productPrice) {
        WarehouseZone--;
        try {
            Zone selectedZone = Zone.getWarehouseZones().get(WarehouseZone);
            int stockedProducts = selectedZone.getStockProductCounter();
            System.out.println("quantità prodotti " + input + " nel settore " + selectedZone.getSector() +
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


    public static void productStockIn(int selectedZoneIndex, int Quantity, String productName, String productBrand, String productDescription, double productPrice) {

        Zone selectedZone = Zone.getWarehouseZones().get(selectedZoneIndex);
        int stockCounter = selectedZone.getStockProductCounter();
        ProductType productNewId = new ProductType(productName, productBrand);
        Product newProduct = new Product(productName, productBrand, productDescription, productPrice, productNewId, selectedZone.getPositions().get(stockCounter));
        selectedZone.getPositions().get(stockCounter).setProductRefId(newProduct.getID());
        selectedZone.getPositions().get(stockCounter).setProduct(newProduct);
        selectedZone.getPositions().get(stockCounter).setQuantity(Quantity);
        selectedZone.incrementStockProductCounter();
    }
    // RICERCA PRODOTTI
    // by name and brand
    public static void searchByName(String name, String brand, int selectedZone) {
        selectedZone--;
        ArrayList<Position> sector = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position position : sector) {
            try {
                String checkName = position.getProduct().getName();
                String checkBrand = position.getProduct().getBrand();
                if (checkName != null && checkBrand != null) {
                    if (checkName.equalsIgnoreCase(name) && checkBrand.equalsIgnoreCase(brand)){
                        System.out.println(position.getProduct());
                        System.out.println(position.getProduct().getPosition().getQuantity());
                    }
                }
            } catch (RuntimeException e) {}
        }
    }
    public static void searchByID(String str, int selectedZone){
        selectedZone--;
        ArrayList<Position> sector = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position position : sector) {
            try {
                String checkID = position.getProduct().getID();
                if (checkID != null) {
                    if (checkID.equalsIgnoreCase(str)) {
                        System.out.println(position.getProduct().getPosition());
                        System.out.println(position.getProduct().getPosition().getQuantity());
                    }
                }
            } catch (RuntimeException e) {}
        }
    }
    public static Product searchByLot(String lot, int selectedZone) {
        selectedZone--;

        ArrayList<Position> sector = Zone.getWarehouseZones().get(selectedZone).getPositions();
        Product risultato = null;
        for (Position position : sector) {

            String firstComparison = convertLotFirst(position.getLot().toString());
            String secondComparison = convertLotSecond(position.getLot().toString());

            if ( convertLotFirst(lot).equalsIgnoreCase(firstComparison) && convertLotSecond(lot).equalsIgnoreCase(secondComparison)) {
                System.out.println(position.getProduct());
                System.out.println(position.getProduct().getPosition().getQuantity());
                risultato = position.getProduct();
            }
        }
        return risultato;
    }
    public static void restockProduct(int zone, String lot, String lot2) {
        zone--;
        ArrayList<Position> sector = Zone.getWarehouseZones().get(zone).getPositions();
        Position selectedPosition1 = null;
        Position selectedPosition2 = null;

        for (Position position : sector) {

            String firstComparison = convertLotFirst(position.getLot().toString());
            String firstComparison2 = convertLotSecond(position.getLot().toString());

            if (convertLotFirst(lot.toString()).equalsIgnoreCase(firstComparison)
            &&  convertLotSecond(lot.toString()).equalsIgnoreCase(firstComparison2)) {
                selectedPosition1 = position;
                selectedPosition1.setProduct(position.getProduct());
            }
            if (convertLotFirst(lot2.toString()).equalsIgnoreCase(firstComparison)
            && convertLotSecond(lot2.toString()).equalsIgnoreCase(firstComparison2)){
                selectedPosition2 = position;
                selectedPosition2.setProduct(position.getProduct());
            }
        }
        Position temporary = new Position();
        if (selectedPosition1.getProduct() == null){
            selectedPosition1.setExistentPosition(selectedPosition2);
            selectedPosition2.removeProduct();
            return;
        } else if (selectedPosition2.getProduct() == null){
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
        Zone.getWarehouseZones().remove(zone);
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
}
