package models.vehicles;

import models.vehicles.interfaces.Fine;

public class Truck extends Vehicle implements Fine {

    public Truck() {
        super(VehicleSize.BIG, 90);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}