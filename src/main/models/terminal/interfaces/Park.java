package main.models.terminal.interfaces;

import main.models.terminal.Terminal;
import main.models.vehicles.Vehicle;

public interface Park {
    boolean parkVehicle(Vehicle vehicle, Terminal terminal);
}
