package org.example;

public class TicTacTester {
    public static void main(String[] args) {
        testNewGame();
        testWinCondition();
        testInvalidMoves();
        System.out.println("All tests passed!");
    }

    static void testNewGame() {
        TicTacToe g = new TicTacToe();
        assert !g.isGameOver();
    }

    static void testWinCondition() {
        TicTacToe g = new TicTacToe();
        g.makeMove("1"); // X
        g.makeMove("4"); // O
        g.makeMove("2"); // X
        g.makeMove("5"); // O
        g.makeMove("3"); // X wins
        assert g.isGameOver();
        assert g.getWinner() == 'X';
    }

    static void testInvalidMoves() {
        TicTacToe g = new TicTacToe();
        assert !g.makeMove("10");
        assert !g.makeMove("abc"); //Testing for incorrect type
        assert !g.makeMove("");
        g.makeMove("1");
        assert !g.makeMove("1");
    }
}