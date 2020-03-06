package com.frog.Ivan.other.codeguesser;

public class Probability {

    private int number;
    private int position;
    private int probability;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public Probability(int number, int position, int probability) {
        this.number = number;
        this.position = position;
        this.probability = probability;
    }

}
