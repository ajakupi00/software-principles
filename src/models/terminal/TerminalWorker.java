package models.terminal;

import models.terminal.interfaces.Park;
import models.vehicles.Vehicle;

public class TerminalWorker extends Worker implements Park {
    private double salary = 0;

    public TerminalWorker(){
    }

    public TerminalWorker(final double cardPercentage){
        this.setCardPercentage(cardPercentage);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        this.salary += getCardPercentage() * vehicle.getPayAmount();
    }

    public double getSalary() {
        return salary;
    }
}
