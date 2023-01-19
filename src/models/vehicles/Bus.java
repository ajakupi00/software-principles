package models.vehicles;

import models.vehicles.interfaces.Fine;

public class Bus extends Vehicle implements Fine {
    public Bus() {
        super(VehicleSize.BIG, 70);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }

    @Override
    public String toString() {
        return "Bus";
    }
}