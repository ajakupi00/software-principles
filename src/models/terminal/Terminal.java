package models.terminal;

import models.terminal.interfaces.Display;
import models.vehicles.Train;
import models.vehicles.TrainSize;

public class Terminal implements Display {
    private final Train train;

    public Terminal(final TrainSize trainSize){
       this.train = new Train(trainSize);
    }

    @Override
    public void displayProfit() {
        System.err.println(train +  "has earned " + this.train.getProfit() + " kn.");
    }

    public Train getTrain() {
        return train;
    }
}
