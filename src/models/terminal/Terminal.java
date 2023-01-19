package models.terminal;

import models.terminal.interfaces.Display;
import models.vehicles.Train;
import models.vehicles.TrainSize;

public class Terminal implements Display {
    private final Train train;
    private final String terminalName;

    private Terminal(final TerminalBuilder builder){
       this.train = new Train(builder.trainSize);
       this.terminalName = builder.terminalName;
    }

    @Override
    public void displayProfit() {
        System.err.println(this.train +  " has earned " + this.train.getProfit() + " kn.\n");
    }

    public Train getTrain() {
        return train;
    }

    public static class TerminalBuilder {

        private final TrainSize trainSize;
        private String terminalName;

        public TerminalBuilder(final TrainSize trainSize) {
            this.trainSize = trainSize;
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
