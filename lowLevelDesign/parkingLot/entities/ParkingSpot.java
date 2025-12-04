package lowLevelDesign.parkingLot.entities;

import lowLevelDesign.parkingLot.vehicle.Vehicle;
import lowLevelDesign.parkingLot.vehicle.VehicleSize;

public class ParkingSpot {
    private String id;
    private Boolean isOccupied;
    private Vehicle vehicle;
    private VehicleSize size;

    public ParkingSpot(String id, VehicleSize size) {
        this.id = id;
        this.isOccupied = false;
        this.vehicle = null;
        this.size = size;
    }

    private void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void unparkVehicle() {
        isOccupied = false;
        vehicle = null;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public VehicleSize getSize() {
        return size;
    }

    public VehicleSize getSpotSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }

    Boolean canVehicleFit(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }
        switch (vehicle.getSize()) {
            case SMALL -> {
                return this.size == VehicleSize.SMALL;
            }
            case MEDIUM -> {
                return this.size == VehicleSize.MEDIUM || this.size == VehicleSize.LARGE;
            }
            case LARGE -> {
                return this.size == VehicleSize.LARGE;
            }
        }
        return false;
    }
}
