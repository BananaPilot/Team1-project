package CRUD.warehouse.position;

import classes.product.Product;
import classes.warehouse.Position;
import classes.warehouse.Zone;

import java.util.ArrayList;

public class PositionCRUD {
    public static void checkPositions(int selectedZone) {
        selectedZone--;
        ArrayList<Position> myPositions = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position element : myPositions) {
            System.out.println(element);
        }
    }

    public static void checkEmptyPositions(int selectedZone) {
        selectedZone--;
        ArrayList<Position> myPositions = Zone.getWarehouseZones().get(selectedZone).getPositions();
        for (Position element : myPositions) {
            if (!element.isPositionEmpty()) {
                System.out.println(element);
            }
        }
    }

    public static void productStockIn(int selectedZoneIndex, Product product) {
        Zone selectedZone = Zone.getWarehouseZones().get(selectedZoneIndex);
        int stockCounter = selectedZone.getStockProductCounter();
        selectedZone.getPositions().get(stockCounter).setProductRefId(product.getID());
        selectedZone.getPositions().get(stockCounter).setProduct(product);
        selectedZone.getPositions().get(stockCounter).setQuantity(product.getCurrentQuantity());
        selectedZone.incrementStockProductCounter();
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
                    && convertLotSecond(lot.toString()).equalsIgnoreCase(firstComparison2)) {
                selectedPosition1 = position;
                selectedPosition1.setProduct(position.getProduct());
            }
            if (convertLotFirst(lot2.toString()).equalsIgnoreCase(firstComparison)
                    && convertLotSecond(lot2.toString()).equalsIgnoreCase(firstComparison2)) {
                selectedPosition2 = position;
                selectedPosition2.setProduct(position.getProduct());
            }
        }
        Position temporary = new Position();
        if (selectedPosition1.getProduct() == null) {
            selectedPosition1.setExistentPosition(selectedPosition2);
            selectedPosition2.removeProduct();
            return;
        } else if (selectedPosition2.getProduct() == null) {
            selectedPosition2.setExistentPosition(selectedPosition1);
            selectedPosition1.removeProduct();
        } else {
            temporary.setExistentPosition(selectedPosition1);
            selectedPosition1.setExistentPosition(selectedPosition2);
            selectedPosition2.setExistentPosition(temporary);
        }
    }

    public static String convertLotFirst(String str) {
        StringBuilder lot = new StringBuilder(str);
        int indexOfMiddle = lot.indexOf("L");
        return lot.substring(0, indexOfMiddle);
    }

    public static String convertLotSecond(String str) {
        StringBuilder lot = new StringBuilder(str);
        int indexOfMiddle = lot.indexOf("L");
        return lot.substring(indexOfMiddle, lot.length() - 1);
    }
}
