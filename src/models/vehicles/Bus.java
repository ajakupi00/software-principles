package models.vehicles;

import models.vehicles.interfaces.Chargeable;

public class Bus extends Vehicle implements Chargeable {
    public Bus() {
        super(VehicleSize.BIG, 70);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}