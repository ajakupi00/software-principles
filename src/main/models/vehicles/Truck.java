package main.models.vehicles;

import main.models.vehicles.interfaces.Fine;

public class Truck extends Vehicle implements Fine {

    public Truck() {
        super(VehicleSize.BIG, 90);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }


    @Override
    public String toString() {
        return "Truck";
    }
}