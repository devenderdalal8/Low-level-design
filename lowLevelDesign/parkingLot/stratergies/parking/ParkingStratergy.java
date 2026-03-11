package parkingLot.stratergies.parking;

import java.util.List;
import java.util.Optional;

import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.vehicle.Vehicle;

public interface ParkingStratergy {
    Optional<ParkingSpot> findParking(Vehicle vehicle , List<ParkingFloor> floors);
}
