package classes.warehouse;

import java.util.ArrayList;
import java.util.UUID;

import database.DB;
import in.Input;

public class Zone {
    private String sector;
    private final ArrayList<Position> positions = new ArrayList<>();

    public Zone(String sector) {
        this.sector = sector;
        buildZone(Input.getInt("Total number of racks: "), Input.getInt("With : "), Input.getInt("Height: "));
    }

    public void buildZone(int totalNumberOfRacks, int widthOfRack, int heightOfRack) {
        for (int numberOfRacks = 0; numberOfRacks < totalNumberOfRacks; numberOfRacks++) {
            for (int height = 0; height < heightOfRack; height++) {
                for (int width = 0; width < widthOfRack; width++) {
                    positions.add(new Position(Position.getWid(), height));
                }
            }
        }
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "sector='" + sector + '\'' +
                ", positions=" + positions +
                '}';
    }
}

