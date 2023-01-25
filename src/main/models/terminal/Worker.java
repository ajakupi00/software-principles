package main.models.terminal;

import main.models.terminal.interfaces.Display;
import main.models.terminal.interfaces.Park;
import main.models.vehicles.HybridCar;
import main.models.vehicles.Vehicle;

public abstract class Worker implements Park, Display {
    private final String name;
    private final double cardPercentage;
    private double salary = 0;

    public Worker(final String name, double cardPercentage){
        this.name = name;
        this.cardPercentage = cardPercentage;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle, Terminal terminal) {
        System.err.println(vehicle + " is being parked by " + name);
        Boolean okToLoad = terminal.getTrain().loadVehicle(vehicle);
        if(!okToLoad){
            return okToLoad;
        }
        this.salary += ((cardPercentage / 100) * vehicle.getPayAmount());
        vehicle.refill();
        if(vehicle instanceof HybridCar){
            ((HybridCar) vehicle).rechargeBattery();
        }
        System.out.println("\n");
        return okToLoad;
    }

    @Override
    public void displayProfit() {
        System.err.println(this.name + " has earned " + this.salary + " kn.\n");
    }
}
