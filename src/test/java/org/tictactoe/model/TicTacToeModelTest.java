package org.tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeModelTest {

    @Test
    void testIfCellsAreEmptyWhenResetGameMethodIsCalled() {
        // Arrange
        TicTacToeModel model = new TicTacToeModel(3, 3);

        // Act
        // SUT: resetGame() is the SUT (System Under Test)
        model.resetGame(); // this method calls initializeBoard() and initializeGame()

        // Assert

        Cell[][] board = model.getBoard();
        for (int row = 0; row < model.getRows(); row++) {
            for (int column = 0; column < model.getColumns(); column++) {
                assertEquals(Symbol.EMPTY, board[row][column].getSymbol());
            }
        }
    }

    @Test
    void testIsValidMoveIsFalseWhenUpdatingCell() {
        TicTacToeModel model = new TicTacToeModel(3, 3);
        model.updateCell(0, 1); // this method calls initializeBoard() and initializeGame()

        // Act
        // SUT: resetGame() is the SUT (System Under Test)
        boolean isValid = model.isValidMove(0, 1); // this method calls initializeBoard() and initializeGame()

        // Assert
        assertFalse(isValid);
    }
}