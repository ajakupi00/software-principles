import models.terminal.Terminal;
import models.terminal.TerminalWorker;
import models.vehicles.*;

public class Main {

    public static void main(String[] args) {
        Terminal smallTrainTerminal = new Terminal(TrainSize.SMALL);
        Terminal bigTrainTerminal = new Terminal(TrainSize.BIG);

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