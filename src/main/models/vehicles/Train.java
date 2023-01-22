package main.models.vehicles;

import main.models.vehicles.interfaces.TrainLoading;

public abstract class Train implements TrainLoading {
    public abstract int getProfit();
}
