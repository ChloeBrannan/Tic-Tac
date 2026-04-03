package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Scoreboard {
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    public void recordWin(char winner) {
        if (winner == 'X') xWins++;
        else if (winner == 'O') oWins++;
        else ties++;
    }

    public void displayStats() {
        System.out.println("\n--- GAME LOG ---");
        System.out.println("Player X Wins: " + xWins);
        System.out.println("Player O Wins: " + oWins);
        System.out.println("Tie Games: " + ties);
        System.out.println("----------------");
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write("Final Game Statistics\n");
            writer.write("Player X Wins: " + xWins + "\n");
            writer.write("Player O Wins: " + oWins + "\n");
            writer.write("Ties: " + ties + "\n");
        } catch (IOException e) {
            System.out.println("Error saving log to disk.");
        }
    }
}