package lowLevelDesign.parkingLot.stratergies.parking;

import java.util.List;
import java.util.Optional;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.vehicle.Vehicle;

public class NearestParkingStratergy implements ParkingStratergy {

    @Override
    public Optional<ParkingSpot> findParking(Vehicle vehicle, List<ParkingFloor> floors) {
       for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
       }
       return Optional.empty();
    }
    
}
