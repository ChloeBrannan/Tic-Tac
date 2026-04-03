package org.example;

public class TicTacTester {
    public static void main(String[] args) {
        testNewGame();
        testWinCondition();
        testInvalidMoves();
        System.out.println("All tests passed!");
    }

    static void testNewGame() {
        // Pass 'X' as the starting player to fix "Expected 1 argument"
        TicTacToe g = new TicTacToe('X');
        assert !g.isGameOver();
    }

    static void testWinCondition() {
        TicTacToe g = new TicTacToe('X');
        g.makeMove("1"); // X
        g.makeMove("4"); // O
        g.makeMove("2"); // X
        g.makeMove("5"); // O
        g.makeMove("3"); // X wins
        assert g.isGameOver();
        assert g.getWinner() == 'X';
    }

    static void testInvalidMoves() {
        TicTacToe g = new TicTacToe('X');

        // We call the method first, then assert the result
        // to avoid "side effects" warnings in the IDE.
        boolean move10 = g.makeMove("10");
        assert !move10;

        boolean moveAbc = g.makeMove("abc");
        assert !moveAbc;

        boolean moveEmpty = g.makeMove("");
        assert !moveEmpty;

        g.makeMove("1");
        boolean moveRepeat = g.makeMove("1");
        assert !moveRepeat;
    }
}