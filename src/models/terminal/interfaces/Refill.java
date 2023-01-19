package models.terminal.interfaces;

import models.terminal.Worker;
import models.vehicles.Vehicle;

public interface Refill {
    void refillGas(Vehicle vehicle, Worker worker);
}
