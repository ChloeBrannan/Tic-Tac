package org.example;

public class TicTacToe {
    private char[] board;
    private char currentPlayer;
    private char winner;

    public TicTacToe() {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        currentPlayer = 'X';
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

    private boolean checkWin() {
        int[][] wins = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        for (int[] combo : wins) {
            if (board[combo[0]] == board[combo[1]] && board[combo[1]] == board[combo[2]]) return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char c : board) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }

    public boolean isGameOver() { return winner != ' '; }
    public char getWinner() { return winner; }
}