package models.terminal;

import models.vehicles.Train;
import models.vehicles.TrainSize;

public class Terminal {
    private final Train train;

    public Terminal(final TrainSize trainSize){
       this.train = new Train(trainSize);
    }

    public Train getTrain() {
        return train;
    }
}
