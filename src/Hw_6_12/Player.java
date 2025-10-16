package Hw_6_12;

public class Player {
    private final String name;

    private int score = 0;
    private int currentNumber;

    public Player(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public void addScore(int score) {
        this.score += score;
    }

}
