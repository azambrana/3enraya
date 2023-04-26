package org.tictactoe.model;

public class TicTacToeModel {
    private Cell[][] board;
    private int rows;
    private int columns;

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        resetGame();
    }

    private void initializeBoard(int rows, int columns) {
        this.board = new Cell[rows][columns];
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.board[row][column] = new Cell(row, column);
            }
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void initializeGame() {
        this.player1 = new Player("Player 1", Symbol.X);
        this.player2 = new Player("Player 2", Symbol.O);
        this.currentPlayer = player1;
    }


    public Cell[][] getBoard () {
        return this.board;
    }
    public void resetGame() {
        initializeBoard(this.rows, this.columns);
        initializeGame();
    }

    public void updateCell(int row, int column) {
        System.out.println("Updating cell " + row + ", " + column + " with symbol " + this.currentPlayer.getSymbol());
        this.setCellSymbol(row, column);
    }

    private void setCellSymbol(int row, int column) {
        this.board[row][column].setSymbol(this.currentPlayer.getSymbol());
    }

    public boolean isValidMove(int row, int column) {
        if ( isGameOver() || isTie() ) {
            return false;
        }

        return isCellEmpty(row, column);
    }

    public boolean isGameOver() {
        for (int row = 0; row < this.rows; row++) {
            if (isRowWinner(row)) {
                return true;
            }
        }

        for (int column = 0; column < this.columns; column++) {
            if (isColumnWinner(column)) {
                return true;
            }
        }

        return isDiagonalWinner();
    }

    private boolean isDiagonalWinner() {
        boolean hasWinner1 = true;
        for (int row = 0; row < this.rows; row++) {
            hasWinner1 = hasWinner1 && this.board[row][row].getSymbol() == this.currentPlayer.getSymbol() && !isCellEmpty(row, row);
        }

        boolean hasWinner2 = true;

        for (int row = 0, column = columns - 1; row < this.rows; row++, column--) {
            hasWinner2 = hasWinner2 && this.board[row][column].getSymbol() == this.currentPlayer.getSymbol() && !isCellEmpty(row, column);
        }

        return hasWinner1 || hasWinner2;
    }

    private boolean isColumnWinner(int column) {
        for (int row = 0; row < this.rows; row++) {
            if (isCellEmpty(row, column)) {
                return false;
            }
            if (this.board[row][column].getSymbol() != this.currentPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowWinner(int row) {
        for (int column = 0; column < this.columns; column++) {
            if (isCellEmpty(row, column)) {
                return false;
            }
            if (this.board[row][column].getSymbol() != this.currentPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTie() {
        return !isGameOver() && hasFullBoard();
    }

    private boolean hasFullBoard() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                if (isCellEmpty(row, column)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCellEmpty(int row, int column) {
        return this.board[row][column].getSymbol() == Symbol.EMPTY;
    }

    public void switchPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public Cell getCell(int row, int column) {
        return this.board[row][column];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
