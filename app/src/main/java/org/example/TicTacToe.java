package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe {
    private final char[] board;
    private char currentPlayer;
    private char winner;

    public TicTacToe(char startingPlayer) {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        currentPlayer = startingPlayer;
        winner = ' ';
    }

    public void printBoard() {
        System.out.println("\n    " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
        System.out.println("  -----+-----+-----");
        System.out.println("    " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
        System.out.println("  -----+-----+-----");
        System.out.println("    " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
    }

    public boolean makeMove(String input) {
        try {
            int spot = Integer.parseInt(input);
            if (spot < 1 || spot > 9 || board[spot - 1] == 'X' || board[spot - 1] == 'O') {
                return false;
            }
            board[spot - 1] = currentPlayer;
            if (checkWin()) {
                winner = currentPlayer;
            } else if (isBoardFull()) {
                winner = 'D';
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public String getComputerMove() {
        int turnNumber = 0;
        for (char c : board) if (c == 'X' || c == 'O') turnNumber++;


        if (turnNumber == 0) {
            int[] corners = {1, 3, 7, 9};
            return String.valueOf(corners[new Random().nextInt(4)]);
        }


        if (turnNumber == 1 && board[4] == '5') return "5";


        for (int i = 1; i <= 9; i++) {
            if (canWinWithMove(String.valueOf(i), currentPlayer)) return String.valueOf(i);
        }


        char opponent = (currentPlayer == 'X') ? 'O' : 'X';
        for (int i = 1; i <= 9; i++) {
            if (canWinWithMove(String.valueOf(i), opponent)) return String.valueOf(i);
        }


        List<String> available = new ArrayList<>();
        for (char c : board) if (c != 'X' && c != 'O') available.add(String.valueOf(c));
        return available.get(new Random().nextInt(available.size()));
    }

    private boolean canWinWithMove(String spotStr, char player) {
        int i = Integer.parseInt(spotStr) - 1;
        if (board[i] == 'X' || board[i] == 'O') return false;

        char original = board[i];
        board[i] = player;
        boolean win = checkWinInternal();
        board[i] = original;
        return win;
    }

    private boolean checkWin() { return checkWinInternal(); }

    private boolean checkWinInternal() {
        int[][] wins = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        for (int[] c : wins) {
            if (board[c[0]] == board[c[1]] && board[c[1]] == board[c[2]]) return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char c : board) if (c != 'X' && c != 'O') return false;
        return true;
    }

    public char getCurrentPlayer() { return currentPlayer; }
    public boolean isGameOver() { return winner != ' '; }
    public char getWinner() { return winner; }
}