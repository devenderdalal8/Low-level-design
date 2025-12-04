package lowLevelDesign.parkingLot.stratergies.parking;

import java.util.List;
import java.util.Optional;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.vehicle.Vehicle;

public class BestParkingStratergy implements ParkingStratergy {

    @Override
    public Optional<ParkingSpot> findParking(Vehicle vehicle, List<ParkingFloor> floors) {
        Optional<ParkingSpot> result = Optional.empty();
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if (spot.isPresent()) {
                if (result.isEmpty() || spot.get().getSize().ordinal() < result.get().getSize().ordinal()) {
                    result = spot;
                }
            }
        }
        return result;
    }

}
