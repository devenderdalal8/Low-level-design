package lowLevelDesign.parkingLot.stratergies.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.vehicle.Vehicle;

public class FartherstParkingStratergy implements ParkingStratergy {

    @Override
    public Optional<ParkingSpot> findParking(Vehicle vehicle, List<ParkingFloor> floors) {
        List<ParkingFloor> availableFloors = new ArrayList<>(floors);
        Collections.reverse(availableFloors);
        for(ParkingFloor floor : availableFloors){
             Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
             if(spot.isPresent()){
                 return spot;
             }
        }
        return Optional.empty();
    }
    
}
