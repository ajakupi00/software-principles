package models.vehicles;

import models.vehicles.interfaces.Chargeable;

public class Van extends Vehicle implements Chargeable {

    public Van() {
        super(VehicleSize.SMALL, 80);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}
