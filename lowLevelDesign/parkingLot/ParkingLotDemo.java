package lowLevelDesign.parkingLot;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.entities.ParkingSpot;
import lowLevelDesign.parkingLot.entities.ParkingTicket;
import lowLevelDesign.parkingLot.stratergies.fee.VehicleBasedFeeStrategy;
import lowLevelDesign.parkingLot.vehicle.Bike;
import lowLevelDesign.parkingLot.vehicle.Vehicle;
import lowLevelDesign.parkingLot.vehicle.VehicleSize;

import java.util.Optional;

public class ParkingLotDemo {
    static ParkingLot parkingLot;

    public static void main(String[] args) {
        System.out.println("Welcome to the Parking Lot System!");
        parkingLot = ParkingLot.getInstance(); // 5 small, 10 medium, 2 large spots

        //Initialize Parking Lot with some vehicles
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot("F1-S1", new ParkingSpot("F1-S1", VehicleSize.SMALL));
        floor1.addSpot("F1-M1", new ParkingSpot("F1-M1", VehicleSize.MEDIUM));
        floor1.addSpot("F1-L1", new ParkingSpot("F1-L1", VehicleSize.LARGE));


        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpot("F2-M1", new ParkingSpot("F2-M1", VehicleSize.MEDIUM));
        floor2.addSpot("F2-M2", new ParkingSpot("F2-M2", VehicleSize.MEDIUM));

        parkingLot.addParkingFloor(floor1);
        parkingLot.addParkingFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        // display available spots
        floor1.displayAvailabilitySpots();
        floor2.displayAvailabilitySpots();

        // park vehicles
        Vehicle car1 = new Vehicle("KA-01-AB-1234", VehicleSize.SMALL);
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car1);

        // park bike
        Vehicle bike2 = new Bike("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        if (car2TicketOpt.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unparkVehicle(car1.getLicenceNumber());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailabilitySpots();
        floor2.displayAvailabilitySpots();
    }
}
