package models.vehicles;


public class Van extends Vehicle {

    public Van() {
        super(VehicleSize.SMALL, 80);
    }

    @Override
    public int payTerminal() {
        return this.getPayAmount();
    }
}
