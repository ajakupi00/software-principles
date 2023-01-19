package models.vehicles;

import models.vehicles.interfaces.Chargeable;

public class Car extends Vehicle implements Chargeable {

    public Car() {
        super(VehicleSize.SMALL, 50);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}
