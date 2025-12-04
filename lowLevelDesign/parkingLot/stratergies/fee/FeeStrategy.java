package lowLevelDesign.parkingLot.stratergies.fee;

import lowLevelDesign.parkingLot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
