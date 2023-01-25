package main.models.terminal;

import main.models.terminal.interfaces.Display;
import main.models.vehicles.BigTrain;
import main.models.vehicles.SmallTrain;
import main.models.vehicles.Train;
import main.models.vehicles.TrainSize;
import main.models.vehicles.interfaces.TrainLoading;

public class Terminal implements Display {
    private final Train train;
    private final String terminalName;

    private Terminal(final TerminalBuilder builder){
       this.train = builder.train;
       this.terminalName = builder.terminalName;
    }

    @Override
    public void displayProfit() {
        System.err.println(this.train +  " has earned " + train.getProfit() + " kn.\n");
    }

    public Train getTrain() {
        return train;
    }

    public static class TerminalBuilder {

        private final Train train;
        private String terminalName;

        public TerminalBuilder(final TrainSize trainSize) {
           if(trainSize == TrainSize.BIG)
               train = new BigTrain();
           else
               train = new SmallTrain();
        }

        public TerminalBuilder terminalName(String terminalName){
            this.terminalName = terminalName;
            return this;
        }

        public Terminal build(){
            Terminal terminal = new Terminal(this);
            return terminal;
        }
    }


}
