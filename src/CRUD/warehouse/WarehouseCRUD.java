package CRUD.warehouse;

import classes.product.Product;
import classes.warehouse.Position;
import classes.warehouse.Zone;
import interactions.warehouse.position.PositionInteractions;

import java.util.ArrayList;

import CRUD.warehouse.position.PositionCRUD;

public class WarehouseCRUD {
    public static void createZone(String zoneName, int zoneLongness, int zoneHeigth) {

        Zone newZone = new Zone(zoneName, zoneLongness, zoneHeigth);
        ArrayList<Position> myPositions = newZone.getPositions();
        for (int index = 0; index < newZone.getZoneCapacity(); index++) {
            Position newPosition = new Position(zoneLongness, zoneName);
            myPositions.add(newPosition);
        }
        PositionInteractions.resetPosition();
        Zone.getWarehouseZones().add(newZone);
    }

    // CONTROLLA TUTTI I SETTORI
    public static void checkWarehouses(){
        for (Zone settore : Zone.getWarehouseZones()){
            System.out.println(settore);
        }
    }
    // CONTROLLA TUTTE POSIZIONI VUOTE O PIENE


    // IL METODO DOVRA' INSERIRE TOT PRODOTTI SCELTI DALL UTENTE NELLA ZONA SCELTA
    public static void stockingManagement(int input, int WarehouseZone, Product product) {
        WarehouseZone--;
        try {
            Zone selectedZone = Zone.getWarehouseZones().get(WarehouseZone);
            int stockedProducts = selectedZone.getStockProductCounter();
            System.out.println("quantità prodotti " + input + " nel settore " + selectedZone.getSector() +
                               " di capacità: " + (selectedZone.getZoneCapacity() - stockedProducts));
            for (int cycles = 0; cycles < input; cycles++){
                 System.out.println("utente seleziona il numero " + cycles + " prodotto da inserire");
                if ((selectedZone.getZoneCapacity() - stockedProducts) >= input) {
                    PositionCRUD.productStockIn(WarehouseZone, product);
                } else {
                    throw new RuntimeException("Capacità settore non sufficiente " + (selectedZone.getZoneCapacity() - stockedProducts));
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
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
}
