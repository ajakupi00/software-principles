package main;

import main.models.terminal.Terminal;
import main.models.terminal.TerminalWorker;
import main.models.vehicles.*;

public class Main {

    public static void main(String[] args) {
        Terminal smallTrainTerminal = new Terminal.TerminalBuilder(TrainSize.SMALL)
                .terminalName("Small train terminal")
                .build();

        Terminal bigTrainTerminal = new Terminal.TerminalBuilder(TrainSize.BIG)
                .terminalName("Big train terminal")
                .build();

        TerminalWorker basicWorker = new TerminalWorker("Basic Worker");
        TerminalWorker advancedWorker = new TerminalWorker("Advanced Worker", 11);

        Vehicle car = new HybridCar();
        Vehicle van = new Van();
        Vehicle bus = new Bus();
        Vehicle truck = new Truck();

        basicWorker.parkVehicle(car, smallTrainTerminal);
        basicWorker.parkVehicle(van, smallTrainTerminal);

        advancedWorker.parkVehicle(bus, bigTrainTerminal);
        advancedWorker.parkVehicle(truck, bigTrainTerminal);

        smallTrainTerminal.displayProfit();
        bigTrainTerminal.displayProfit();

        basicWorker.displayProfit();
        advancedWorker.displayProfit();
    }
}