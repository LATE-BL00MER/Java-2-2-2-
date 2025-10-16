package Hw_6_12;

import java.util.Random;
import java.util.Scanner;

public class NumberExpectationGame {
    private final Scanner scanner = new Scanner(System.in);
    private final Random rand = new Random();

    private Player[] players;
    private int[] randomNumbers = new int[15];
    private boolean isGameRunning = true;

    public void run() {
        initializePlayer();
        getPlayerChoices();

        while (isGameRunning) {
            generateRandomNumbers();
            checkPlayerChoices();
            removeWinner();
        }
    }

    public void initializePlayer() {
        System.out.print("게임에 참여할 선수들 이름>>");
        String[] playerNames = scanner.nextLine().split(" ");

        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }

    private void getPlayerChoices() {
        for (Player player : players) {
            System.out.printf("[%s] 정수 선택 (1~10) >>", player.getName());
            int choice = Integer.parseInt(scanner.nextLine());
            player.setCurrentNumber(choice);
        }

    }

    private void generateRandomNumbers() {
        System.out.println();
        System.out.print("Enter 키 입력>>");
        scanner.nextLine();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(1, 11);
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println();
    }

    private void checkPlayerChoices() {
        for (Player player : players) {
            int count = 0;
            for (int n : randomNumbers) {
                if (n == player.getCurrentNumber()) {
                    count++;
                }
            }

            player.addScore(count);
            System.out.printf("[%s] 맞춘 개수: %d]\n", player.getName(), player.getScore());
        }
    }

    private void removeWinner() {
        int minScore = players[0].getScore();
        for (Player player : players) {
            if (player.getScore() < minScore) {
                minScore = player.getScore();
            }
        }

        // 최저 점수를 가진 사람들만을 담을 배열 만들기
        int minScoreCount = 0;
        for (Player player : players) {
            if (player.getScore() == minScore) {
                minScoreCount++;
            }
        }

        Player[] losers = new Player[minScoreCount];
        int index = 0;

        // 4. 최저 점수 가진 사람들을 새로운 배열에 옮기기
        System.out.print("현재 패자들 : ");
        for (Player player : players) {
            if (player.getScore() == minScore) {
                losers[index++] = player;
                System.out.print(player.getName() + " ");
            }
        }

        this.players = losers;

        if (players.length == 1) {
            System.out.println();
            System.out.printf("최종 패자는 %s 입니다.\n", players[0].getName());
            isGameRunning = false;
        }
    }
}
