package lowLevelDesign.parkingLot.vehicle;

public class Car extends Vehicle {
    public Car(String licenceNumber) {
        super(licenceNumber, VehicleSize.MEDIUM);
    }
}
