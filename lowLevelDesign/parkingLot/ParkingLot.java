package lowLevelDesign.parkingLot;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.entities.ParkingTicket;
import lowLevelDesign.parkingLot.stratergies.fee.FeeStrategy;
import lowLevelDesign.parkingLot.stratergies.fee.VehicleBasedFeeStrategy;
import lowLevelDesign.parkingLot.stratergies.parking.BestParkingStratergy;
import lowLevelDesign.parkingLot.stratergies.parking.ParkingStratergy;
import lowLevelDesign.parkingLot.vehicle.Vehicle;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;
    public ParkingStratergy parkingStratergy;
    public FeeStrategy feeStrategy;
    private final List<ParkingFloor> floors;
    private final Map<String, ParkingTicket> activeTickets;

    private ParkingLot() {
        this.feeStrategy = new VehicleBasedFeeStrategy();
        this.parkingStratergy = new BestParkingStratergy();
        this.floors = new ArrayList<>();
        activeTickets = new ConcurrentHashMap<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addParkingFloor(ParkingFloor floor) {
        this.floors.add(floor);
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        Optional<ParkingSpot> spot = parkingStratergy.findParking(vehicle, floors);
        return spot.orElse(null);
    }


    public void setParkingStrategy(ParkingStratergy parkingStratergy) {
        this.parkingStratergy = parkingStratergy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = parkingStratergy.findParking(vehicle, floors);
        if (parkingSpot.isPresent()) {
            ParkingSpot spot = parkingSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(ticket.getVehicle().getLicenceNumber(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenceNumber(), spot.getId(), ticket.getTicketId());
            return Optional.of(ticket);
        }
        System.out.println("No parking spot available for vehicle: " + vehicle.getLicenceNumber());
        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String licenseNumber) {
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if (ticket == null) {
            System.out.println("Invalid Ticket");
            return Optional.empty();
        }
        ticket.setExitTime();
        return Optional.of(feeStrategy.calculateFee(ticket));
    }
}
