package models.terminal.interfaces;

import models.terminal.Terminal;
import models.vehicles.Vehicle;

public interface Park {
    void parkVehicle(Vehicle vehicle, Terminal terminal);
}
