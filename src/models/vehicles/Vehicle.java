package models.vehicles;

public abstract class Vehicle {
    private final VehicleSize vehicleSize;
    private final int payAmount;

    public Vehicle(final VehicleSize vehicleSize, final int payAmount){
        this.vehicleSize = vehicleSize;
        this.payAmount = payAmount;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getPayAmount() {
        return payAmount;
    }
}

