package lowLevelDesign.parkingLot.vehicle;

public class Vehicle {
    private String licenceNumber;
    private VehicleSize size;

    public Vehicle(String licenceNumber, VehicleSize size) {
        this.licenceNumber = licenceNumber;
        this.size = size;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }

}
