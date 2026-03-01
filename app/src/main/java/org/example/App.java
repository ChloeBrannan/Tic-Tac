package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean playAgain = true;

    System.out.println("Welcome to Tic-Tac-Toe game!");

    while (playAgain) {
      TicTacToe game = new TicTacToe();
      while (!game.isGameOver()) {
        game.printBoard();
        System.out.print("\nPlease select your move? ");
        String input = scanner.nextLine().trim();

        if (!game.makeMove(input)) {
          System.out.println("\nThat is not a valid move! Please try again.");
        }
      }

      game.printBoard();
      if (game.getWinner() != 'D') {
        System.out.println("\nPlayer " + game.getWinner() + " wins!");
      } else {
        System.out.println("\ndraw!");
      }

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
    System.out.println("\nGoodbye!");
  }
}