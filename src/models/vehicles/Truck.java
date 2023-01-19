package models.vehicles;

import models.vehicles.interfaces.Chargeable;

public class Truck extends Vehicle implements Chargeable {

    public Truck() {
        super(VehicleSize.BIG, 90);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}