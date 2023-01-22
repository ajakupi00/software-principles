package test;

import main.models.terminal.Terminal;
import main.models.terminal.TerminalWorker;
import main.models.vehicles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerminalWorkerTest {

    @Test
    public void testParkingVehicle(){
        Terminal smallTrainTerminal = new Terminal.TerminalBuilder(TrainSize.SMALL)
                .terminalName("Small train terminal")
                .build();


        TerminalWorker basicWorker = new TerminalWorker("Basic Worker");

        Vehicle car = new HybridCar();
        Vehicle bus = new Bus();

        boolean carOK = basicWorker.parkVehicle(car, smallTrainTerminal);
        boolean busOK = basicWorker.parkVehicle(bus, smallTrainTerminal);

        assertEquals(true, carOK);
        assertEquals(false, busOK);
    }
}
