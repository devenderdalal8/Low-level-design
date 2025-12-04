package lowLevelDesign.parkingLot.stratergies.fee;

import lowLevelDesign.parkingLot.entities.ParkingTicket;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    public static final double SMALL_VEHICLE_RATE = 5.0;
    public static final double MEDIUM_VEHICLE_RATE = 10.0;
    public static final double LARGE_VEHICLE_RATE = 15.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long spentTime = ticket.getExitTime() - ticket.getEntryTime();
        double hoursSpent = Math.ceil(spentTime / 3600000.0); // Convert milliseconds to hours
        return switch (ticket.getVehicle().getSize()) {
            case SMALL -> hoursSpent * SMALL_VEHICLE_RATE;
            case MEDIUM -> hoursSpent * MEDIUM_VEHICLE_RATE;
            case LARGE -> hoursSpent * LARGE_VEHICLE_RATE;
        };
    }
}
