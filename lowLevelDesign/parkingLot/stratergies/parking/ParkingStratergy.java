package lowLevelDesign.parkingLot.stratergies.parking;

import java.util.List;
import java.util.Optional;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.vehicle.Vehicle;

public interface ParkingStratergy {
    Optional<ParkingSpot> findParking(Vehicle vehicle , List<ParkingFloor> floors);
}
