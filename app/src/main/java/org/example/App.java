package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Scoreboard scoreboard = new Scoreboard();
    boolean playAgain = true;
    char nextStarter = 'X';

    System.out.println("Welcome to Tic-Tac-Toe game!");

    while (playAgain) {
      TicTacToe game = new TicTacToe(nextStarter);
      while (!game.isGameOver()) {
        game.printBoard();
        System.out.print("\nIt is Player " + game.getCurrentPlayer() + "'s turn.");
        System.out.print("\nPlease select your move (1-9): ");
        String input = scanner.nextLine().trim();

        if (!game.makeMove(input)) {
          System.out.println("\nThat is not a valid move! Please try again.");
        }
      }

      game.printBoard();
      char winner = game.getWinner();
      if (winner != 'D') {
        System.out.println("\nPlayer " + winner + " wins!");
        nextStarter = (winner == 'X') ? 'O' : 'X';
      } else {
        System.out.println("\nIt's a draw!");
        // On a draw, nextStarter remains the same as the previous game's starter
      }

      scoreboard.recordWin(winner);
      scoreboard.displayStats();

      boolean validResponse = false;
      while (!validResponse) {
        System.out.print("\nWould you like to play again (yes/no)? ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
          validResponse = true;
        } else if (response.equals("no")) {
          validResponse = true;
          playAgain = false;
        } else {
          System.out.println("\nThat is not a valid entry!");
        }
      }
    }

    scoreboard.saveToFile();
    System.out.println("\nGame log saved to scoreboard.txt. Goodbye!");
  }
}