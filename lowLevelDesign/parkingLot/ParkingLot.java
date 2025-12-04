package lowLevelDesign.parkingLot;

import lowLevelDesign.parkingLot.entities.ParkingFloor;
import lowLevelDesign.parkingLot.stratergies.parking.BestParkingStratergy;
import lowLevelDesign.parkingLot.stratergies.parking.ParkingStratergy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    // fee , ticket , space ,floor
    // fee -> calculateFee() , issueTicket() , processPayment()
    // ticket -> generateTicket() , validateTicket()
    // space -> isAvailable() , reserveSpace() , freeSpace()
    // floor -> getAvailableSpaces() , getTotalSpaces()

    private static ParkingLot instance;
    public ParkingStratergy parkingStratergy;
    private List<ParkingFloor> floors;

    private ParkingLot() {
        this.parkingStratergy = new BestParkingStratergy();
        this.floors = new ArrayList<>();
    }
    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }
}
