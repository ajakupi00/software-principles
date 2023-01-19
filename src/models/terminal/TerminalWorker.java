package models.terminal;

import models.terminal.interfaces.Display;
import models.terminal.interfaces.Park;
import models.vehicles.HybridCar;
import models.vehicles.Vehicle;

public class TerminalWorker implements Park, Display {
    private final String name;
    private double cardPercentage = 10.0;
    private double salary = 0;

    public TerminalWorker(final String name){
        this.name = name;
    }
    public TerminalWorker(final String name, final double cardPercentage){
        this.name = name;
        this.cardPercentage = cardPercentage;
    }

    @Override
    public void parkVehicle(Vehicle vehicle, Terminal terminal) {
        System.err.println(vehicle + " is being parked by " + name);
        terminal.getTrain().loadVehicle(vehicle);
        this.salary += ((cardPercentage / 100) * vehicle.getPayAmount());
        vehicle.refill();
        if(vehicle instanceof HybridCar){
            ((HybridCar) vehicle).rechargeBattery();
        }
        System.out.println("\n");
    }

    @Override
    public void displayProfit() {
        System.err.println(this.name + " has earned " + this.salary + " kn.");
    }
}
