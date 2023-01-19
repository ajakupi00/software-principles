package main.models.vehicles;

import main.models.vehicles.interfaces.Fine;
import main.models.vehicles.interfaces.Refuelable;

public abstract class Vehicle implements Fine, Refuelable {
    private final VehicleSize vehicleSize;
    private final int payAmount;

    private int gasPercentage;

    public Vehicle(final VehicleSize vehicleSize, final int payAmount){
        this.vehicleSize = vehicleSize;
        this.payAmount = payAmount;
        this.gasPercentage = (int) (Math.random() * 100);
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public int getGasPercentage() {
        return gasPercentage;
    }

    @Override
    public void refill() {
        if(this.getGasPercentage() >= 10){
            System.err.println("No need for gas, gas percentage is " + this.getGasPercentage() + "\n");
        }else{
            System.err.println("Refilling vehicle gas.\n");
            this.gasPercentage = 100;
            System.err.println("Vehicle refueled.\n");
        }
    }
}

