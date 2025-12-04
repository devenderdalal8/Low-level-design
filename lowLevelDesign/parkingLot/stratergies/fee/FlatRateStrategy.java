package lowLevelDesign.parkingLot.stratergies.fee;

import lowLevelDesign.parkingLot.entities.ParkingTicket;

public class FlatRateStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long timeSpent = ticket.getExitTime() - ticket.getEntryTime();
        double hoursSpent = Math.ceil(timeSpent / 3600000.0); // Convert milliseconds to hours
        return hoursSpent * RATE_PER_HOUR;
    }
}
