package lowLevelDesign.parkingLot.entities;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lowLevelDesign.parkingLot.vehicle.Vehicle;
import lowLevelDesign.parkingLot.vehicle.VehicleSize;

public class ParkingFloor {

    private int parkingFloor;
    private Map<String, ParkingSpot> spots;

    ParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
        spots = new ConcurrentHashMap<>();
    }

    void addSpot(String key, ParkingSpot spot) {
        spots.put(key, spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        System.out.printf("--- Floor %d Availability ---\n", parkingFloor);
        return spots.values().stream()
                .filter(spot -> !spot.getIsOccupied() && spot.canVehicleFit(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize))
                .findFirst();
    }

    void displayAvailabilitySpots() {
        Map<Object, Long> availableBySize = spots.values().stream()
                .filter(spot -> !spot.getIsOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSize, Collectors.counting()));

        for (VehicleSize size : VehicleSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableBySize.getOrDefault(size, 0L));
        }
    }
}
