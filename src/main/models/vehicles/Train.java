package main.models.vehicles;

import main.models.vehicles.interfaces.TrainLoading;

public class Train implements TrainLoading {
    private final TrainSize trainSize;

    private int currentCapacity;
    private int profit = 0;

    public Train(TrainSize trainSize){
        this.trainSize = trainSize;
        this.currentCapacity = trainSize.getCapacity();
    }

    @Override
    public boolean loadVehicle(Vehicle vehicle) {
        if(this.trainSize.getVehicleSizeType() != vehicle.getVehicleSize()){
            System.err.println("Vehicle doesn't match train vehicle size type!");
            return false;
        }else if(this.currentCapacity == 0){
            System.err.println("Train is in capacity.\nSorry, your vehicle can't be loaded on this train.");
            return false;
        }
        this.profit += vehicle.getPayAmount();
        this.currentCapacity--;
        return true;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        switch (this.trainSize) {
            case BIG -> {
                return "Big train";
            }
            case SMALL -> {
                return "Small train";
            }
            default -> {
                return "Train";
            }
        }
    }
}
