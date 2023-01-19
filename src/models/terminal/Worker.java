package models.terminal;

public abstract class Worker {
    private double cardPercentage = 10.0;

    public Worker(){
    }

    public Worker(final double cardPercentage){
        this.cardPercentage = cardPercentage;
    }

    public double getCardPercentage() {
        return cardPercentage;
    }

    public void setCardPercentage(double cardPercentage) {
        this.cardPercentage = cardPercentage;
    }
}
