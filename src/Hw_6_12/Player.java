package Hw_6_12;

public class Player {
    private String name; // 선수들의 이름
    private int score = 0; // 선수들의 점수
    private int currentNumber; // 선수가 현재 선택한 번호

    //선수 이름변수 this.name = name으로 초기화
    public Player(String name) { this.name = name; }

    // getter로 (여기 주석 어케 달지)
    public String getName() {
        return name;
    }

    //
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
