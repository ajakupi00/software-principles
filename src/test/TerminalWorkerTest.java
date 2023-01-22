package test;

import main.models.terminal.Terminal;
import main.models.terminal.BasicWorker;
import main.models.terminal.Worker;
import main.models.vehicles.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerminalWorkerTest {
    private static Worker basicWorker;
    private static Terminal smallTrainTerminal;
    private static Terminal bigTrainTerminal;
    private static Vehicle bus;

    @BeforeAll
    public static void initWorker(){
        basicWorker = new BasicWorker("Basic Worker");
        smallTrainTerminal = new Terminal.TerminalBuilder(TrainSize.SMALL)
                .terminalName("Small train terminal")
                .build();
        bigTrainTerminal = new Terminal.TerminalBuilder(TrainSize.BIG)
                .terminalName("Big train terminal")
                .build();
        bus = new Bus();
    }

    @Test
    public void testParkingVehicle(){
        Vehicle car = new HybridCar();

        boolean carOK = basicWorker.parkVehicle(car, smallTrainTerminal);
        boolean busOK = basicWorker.parkVehicle(bus, smallTrainTerminal);

        assertEquals(true, carOK);
        assertEquals(false, busOK);
    }

    @Test
    public void testVehiclePaying(){
        basicWorker.parkVehicle(bus, bigTrainTerminal);
        assertEquals(70,bigTrainTerminal.getTrain().getProfit());

    }
}
