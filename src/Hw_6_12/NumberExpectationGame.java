package Hw_6_12;

import java.util.Scanner;

public class NumberExpectationGame {
    private final Scanner scanner = new Scanner(System.in);

    private Player[] players;
    private int[] randomNumbers = new int[15];
    private boolean isGameRunning = true;

    public void run() {
        initializePlayers();
        getPlayerChoices();

        while (isGameRunning) {
            generateRandomNumbers();
            checkPlayerChoices();
            removeWinners();
        }
    }

    public void initializePlayers() {
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
            randomNumbers[i] = (int)(Math.random() * 10) + 1;
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println();
    }

    private void checkPlayerChoices() {
        for (Player player : players) {
            int matchCount = 0;
            for (int num : randomNumbers) {
                if (num == player.getCurrentNumber()) {
                    matchCount++;
                }
            }
            player.addScore(matchCount);
            System.out.printf("[%s] 맞춘 개수: %d\n", player.getName(), player.getScore());
        }
    }

    private void removeWinners() {
        int minScore = players[0].getScore();
        for (Player player : players) {
            if (player.getScore() < minScore) {
                minScore = player.getScore();
            }
        }

        int loserCount = 0;
        for (Player player : players) {
            if (player.getScore() == minScore) {
                loserCount++;
            }
        }

        Player[] nextRoundPlayers = new Player[loserCount];
        int index = 0;

        System.out.print("현재 패자들 : ");
        for (Player player : players) {
            if (player.getScore() == minScore) {
                nextRoundPlayers[index++] = player;
                System.out.print(player.getName() + " ");
            }
        }
        System.out.println();

        this.players = nextRoundPlayers;

        if (players.length == 1) {
            System.out.printf("최종 패자는 %s 입니다.\n", players[0].getName());
            isGameRunning = false;
        }
    }
}